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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class Application {

	@Autowired
	IP2regionTemplate template;

	@PostConstruct
	public void test() throws IOException {


		// 根据IP进行搜索(默认使用内存算法)
		System.out.println(template.memorySearch("127.0.0.1"));
		System.out.println(template.memorySearch("61.94.43.82"));

		// 根据IP获取对应地区
		System.out.println(template.getRegion("127.0.0.1"));
		System.out.println(template.getRegion("114.124.146.103"));

		// 根据IP获取对应地区详细信息对象
		RegionAddress adress1 = template.getRegionAddress("113.210.53.80");
		System.out.println(adress1);
		System.out.println(RegionEnum.getByRegionAddress(adress1));

		RegionAddress adress2 = template.getRegionAddress("127.0.0.1");
		System.out.println(adress2);
		System.out.println(RegionEnum.getByRegionAddress(adress2));

		// 根据IP获取对应国家
		RegionEnum regionEnum1 = template.getRegionByIp("127.0.0.1");
		System.out.println(regionEnum1);
		RegionEnum regionEnum2 = template.getRegionByIp("102.42.140.162");
		System.out.println(regionEnum2);

		// 根据IP获取对应地区枚举
		System.out.println(template.getCountryByIp("127.0.0.1"));
		System.out.println(template.getCountryByIp("114.124.146.103"));

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
