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

import javax.annotation.PostConstruct;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Autowired
	IP2regionTemplate template;

	@PostConstruct
	public void test() throws IOException {

	   System.out.println( template.btreeSearch("61.94.43.82"));
	   System.out.println( template.binarySearch("61.94.43.82"));
	   System.out.println( template.memorySearch("61.94.43.82"));
	   System.out.println(template.binarySearch("127.0.0.1"));

	   // 根据IP获取对应国家
	   System.out.println(template.getCountryByIp("127.0.0.1"));

	   // 根据IP获取对应地区
	   System.out.println(template.getRegion("114.124.146.103"));

	   // 根据IP获取对应地区详细信息对象
	   RegionAddress adress1 = template.getRegionAddress("113.210.53.80");
	   System.out.println(adress1);
	   System.out.println(RegionEnum.getByRegionAddress(adress1));

	   // 根据IP获取对应地区枚举
	   RegionEnum regionEnum = template.getRegionByIp("102.42.140.162");
	   System.out.println(regionEnum);

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
