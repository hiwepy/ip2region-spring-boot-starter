/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.hiwepy.ip2region.spring.boot;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import org.lionsoul.ip2region.xdb.Searcher;
import org.nutz.plugins.ip2region.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

public class IP2regionXdbTemplate implements DisposableBean {

	protected Logger log = LoggerFactory.getLogger(IP2regionXdbTemplate.class);
	protected ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	protected static String NOT_MATCH = "未分配或者内网IP|0|0|0|0";
	protected static RegionAddress NOT_MATCH_REGION_ADDRESS = new RegionAddress(NOT_MATCH.split("\\|"));
	protected String dbPath;
	protected byte[] xdbBuff;
	protected Searcher searcher;

	public IP2regionXdbTemplate(String dbPath) throws IOException {
		this.dbPath = dbPath;
		this.initSearcher();
	}

	private void initSearcher() throws IOException {
		// 1、从 dbPath 加载整个 xdb 到内存。
		if (Objects.isNull(xdbBuff)) {
			try {
				xdbBuff = Searcher.loadContentFromFile(dbPath);
			} catch (Exception e) {
				log.error("failed to load content from `{}`: \n", dbPath, e);
			}
		}
		// 2、使用上述的 xdbBuff 创建一个完全基于内存的查询对象。
		if (Objects.isNull(searcher)) {
			try {
				searcher = Searcher.newWithBuffer(xdbBuff);
			} catch (Exception e) {
				log.error("failed to create content cached searcher: \n", e);
			}
		}
	}

	/**
	 * get the region with a int ip address with memory binary search algorithm
	 *
	 * @param   ip
	 * @throws IOException
	 */
	public String memorySearch(long ip) throws IOException {
		if(Objects.isNull(xdbBuff) || Objects.isNull(searcher)){
			return NOT_MATCH;
		}
		long sTime = System.nanoTime();
		String region = searcher.search(ip);
		int ioCount = searcher.getIOCount();
		long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
		log.info(" IP : {} >> { region: {}, ioCount: {}, took: {} μs }\n", ip, region, ioCount, cost);
		// not matched
		if (!StringUtils.hasText(region)) {
			return NOT_MATCH;
		}
		return region;
	}

	/**
	 * get the region throught the ip address with memory binary search algorithm
	 *
	 * @param   ip
	 * @return  DataBlock
	 * @throws  IOException
	 */
	public String memorySearch(String ip) throws IOException {
		return memorySearch(Util.ip2long(ip));
	}

	public String getRegion(String ip) {
		try {
			rwl.readLock().lock();
			String region = this.memorySearch(ip);
			log.info(" IP : {} >> Region : {} ", ip, region);
			return region;
		} catch (Exception e) {
			log.error("IP : {} >> Country/Region Parser Error：{}", ip, e.getMessage());
			return NOT_MATCH;
		} finally {
			rwl.readLock().unlock();
		}
	}

	public RegionAddress getRegionAddress(String ip) {
		try {
			rwl.readLock().lock();
			// {region: 美国|0|华盛顿|0|谷歌, ioCount: 7, took: 82 μs}
			String region = this.memorySearch(ip);
			log.info(" IP : {} >> Region : {} ", ip, region);
			return new RegionAddress(region.split("\\|"));
		} catch (Exception e) {
			log.error(" IP : {} >> Country/Region Parser Error：{}", ip, e.getMessage());
			return NOT_MATCH_REGION_ADDRESS;
		} finally {
			rwl.readLock().unlock();
		}
	}

	public String getCountryByIp(String ip) {
		try {
			rwl.readLock().lock();
			String region = this.memorySearch(ip);
			log.info(" IP : {} >> Region : {} ", ip, region);
			String country = region.split("\\|")[0];
			log.info(" IP : {} >> Country/Region : {} ", ip, country);
			return NOT_MATCH.contains(country) ? RegionEnum.UK.getCname() : country;
		} catch (Exception e) {
			log.error(" IP : {} >> Country/Region Parser Error：{}", ip, e.getMessage());
			return RegionEnum.UK.getCname();
		} finally {
			rwl.readLock().unlock();
		}
	}

	public RegionEnum getRegionByIp(String ip) {
		try {
			rwl.readLock().lock();
			String region = this.memorySearch(ip);
			log.info(" IP : {} >> Region : {} ", ip, region);
			String[] regionArr = region.split("\\|");
			log.info(" IP : {} >> Country : {} ", ip, regionArr[0]);
			if(NOT_MATCH.contains(regionArr[0])){
				return RegionEnum.UK;
			}
			RegionAddress address = new RegionAddress(regionArr);
			return RegionEnum.getByRegionAddress(address);
		} catch (Exception e) {
			log.error(" IP : {} >> Country/Region Parser Error：{}", ip, e.getMessage());
			return RegionEnum.UK;
		} finally {
			rwl.readLock().unlock();
		}
	}

	public boolean isMainlandIp(String ip) {
		RegionEnum regionEnum = this.getRegionByIp(ip);
		return RegionEnum.CN.compareTo(regionEnum) == 0 &&
				RegionEnum.HK.compareTo(regionEnum) != 0 &&
				RegionEnum.MO.compareTo(regionEnum) != 0 &&
				RegionEnum.TW.compareTo(regionEnum) != 0;
	}

	@Override
	public void destroy() throws Exception {
		searcher.close();
	}

}
