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

import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.nutz.plugins.ip2region.DataBlock;
import org.nutz.plugins.ip2region.DbSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import com.github.hiwepy.ip2region.spring.boot.util.IpUtils;

public class IP2regionTemplate implements DisposableBean {

	protected Logger log = LoggerFactory.getLogger(IP2regionTemplate.class);
	protected DbSearcher dbSearcher = null;
	protected ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	protected static String NOT_MATCH = "未分配或者内网IP|0|0|0|0";
	protected static RegionAddress NOT_MATCH_REGION_ADDRESS = new RegionAddress(NOT_MATCH.split("\\|"));

	public IP2regionTemplate(final DbSearcher dbSearcher) throws IOException {
		this.dbSearcher = dbSearcher;
	}

	/**
	 * get the region with a int ip address with memory binary search algorithm
	 *
	 * @param ip ： int ip address
	 * @return {@link DataBlock} instance
	 * @throws IOException if reader db file error
	 */
	public DataBlock memorySearch(long ip) throws IOException {
		try {

			rwl.readLock().lock();
			return dbSearcher.memorySearch(ip);
		} finally {
			rwl.readLock().unlock();
		}
	}

	/**
	 * get the region throught the ip address with memory binary search algorithm
	 *
	 * @param ip ： string ip address
	 * @return {@link DataBlock} instance
	 * @throws IOException if reader db file error
	 */
	public DataBlock memorySearch(String ip) throws IOException {
		try {
			rwl.readLock().lock();
			return dbSearcher.memorySearch(ip);
		} finally {
			rwl.readLock().unlock();
		}
	}

	/**
	 * get by index ptr
	 *
	 * @param ptr ： index ptr
	 * @return {@link DataBlock} instance
	 * @throws IOException if reader db file error
	 */
	public DataBlock getByIndexPtr(long ptr) throws IOException {
		try {
			rwl.readLock().lock();
			return dbSearcher.getByIndexPtr(ptr);
		} finally {
			rwl.readLock().unlock();
		}
	}

	/**
	 * get the region with a int ip address with b-tree algorithm
	 *
	 * @param ip ： int ip address
	 * @return {@link DataBlock} instance
	 * @throws IOException if reader db file error
	 */
	public DataBlock btreeSearch(long ip) throws IOException {
		try {
			rwl.readLock().lock();
			return dbSearcher.btreeSearch(ip);
		} finally {
			rwl.readLock().unlock();
		}
	}

	/**
	 * get the region throught the ip address with b-tree search algorithm
	 *
	 * @param ip ： string ip address
	 * @return {@link DataBlock} instance
	 * @throws IOException if reader db file error
	 */
	public DataBlock btreeSearch(String ip) throws IOException {
		try {
			rwl.readLock().lock();
			return dbSearcher.btreeSearch(ip);
		} finally {
			rwl.readLock().unlock();
		}
	}

	/**
	 * get the region with a int ip address with binary search algorithm
	 *
	 * @param ip ： int ip address
	 * @return {@link DataBlock} instance
	 * @throws IOException if reader db file error
	 */
	public DataBlock binarySearch(long ip) throws IOException {
		try {
			rwl.readLock().lock();
			return dbSearcher.binarySearch(ip);
		} finally {
			rwl.readLock().unlock();
		}
	}

	/**
	 * get the region throught the ip address with binary search algorithm
	 *
	 * @param ip ： string ip address
	 * @return {@link DataBlock} instance
	 * @throws IOException if reader db file error
	 */
	public DataBlock binarySearch(String ip) throws IOException {
		try {
			rwl.readLock().lock();
			return dbSearcher.binarySearch(ip);
		} finally {
			rwl.readLock().unlock();
		}
	}

	public String getRegion(String ip) {
		try {
			rwl.readLock().lock();
			if(!IpUtils.isIpv4(ip)){
				return NOT_MATCH;
			}
			String region = dbSearcher.memorySearch(ip).getRegion();
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
			if(!IpUtils.isIpv4(ip)){
				return NOT_MATCH_REGION_ADDRESS;
			}
			String region = dbSearcher.memorySearch(ip).getRegion();
			log.info(" IP : {} >> Region : {} ", ip, region);
			return new RegionAddress(region.split("\\|"));
		} catch (Exception e) {
			log.error("IP : {} >> Country/Region Parser Error：{}", ip, e.getMessage());
			return NOT_MATCH_REGION_ADDRESS;
		} finally {
			rwl.readLock().unlock();
		}
	}

	public String getCountryByIp(String ip) {
		try {
			rwl.readLock().lock();
			if(!IpUtils.isIpv4(ip)){
				return RegionEnum.UK.getCname();
			}
			String region = dbSearcher.memorySearch(ip).getRegion();
			log.info(" IP : {} >> Region : {} ", ip, region);
			String country = region.split("\\|")[0];
			log.info(" IP : {} >> Country/Region : {} ", ip, country);
			return NOT_MATCH.contains(country) ? RegionEnum.UK.getCname() : country;
		} catch (Exception e) {
			log.error("IP : {} >> Country/Region Parser Error：{}", ip, e.getMessage());
			return RegionEnum.UK.getCname();
		} finally {
			rwl.readLock().unlock();
		}
	}

	public RegionEnum getRegionByIp(String ip) {
		try {
			rwl.readLock().lock();
			if(!IpUtils.isIpv4(ip)){
				return RegionEnum.UK;
			}
			String region = dbSearcher.memorySearch(ip).getRegion();
			log.info(" IP : {} >> Region : {} ", ip, region);
			String[] regionArr = region.split("\\|");
			log.info(" IP : {} >> Country : {} ", ip, regionArr[0]);
			if(NOT_MATCH.contains(regionArr[0])){
				return RegionEnum.UK;
			}
			RegionAddress address = new RegionAddress(regionArr);
			return RegionEnum.getByRegionAddress(address);
		} catch (Exception e) {
			log.error("IP : {} >> Country/Region Parser Error：{}", ip, e.getMessage());
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
		dbSearcher.close();
	}

}
