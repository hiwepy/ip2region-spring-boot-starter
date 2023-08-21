package com.github.hiwepy.ip2region.spring.boot;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import com.github.hiwepy.ip2region.spring.boot.ext.XdbSearcher;
import org.junit.Before;
import org.junit.Test;

public class IP2RegionTemplate_Test {

	IP2regionTemplate template = null;

	@Before
	public void setUp()  throws Exception {
		String dbPath = "D:\\data\\ip2region.xdb";
		XdbSearcher xdbSearcher = new XdbSearcher(dbPath);
		template = new IP2regionTemplate(xdbSearcher);
	}

	@Test
	public void templateTest() throws Exception {

		System.out.println(template.getCountryByIp("127.0.0.1"));
		System.out.println(template.getRegion("114.124.146.103"));

		RegionAddress adress1 = template.getRegionAddress("113.210.53.80");
		System.out.println(adress1);
		System.out.println(RegionEnum.getByRegionAddress(adress1));

		RegionAddress adress2 = template.getRegionAddress("127.0.0.1");
		System.out.println(adress2);
		System.out.println(RegionEnum.getByRegionAddress(adress2));

		RegionEnum regionEnum = template.getRegionByIp("102.42.140.162");
		System.out.println(regionEnum);

		System.out.println(template.memorySearch("114.124.146.103"));
		System.out.println(template.memorySearch("115.193.169.84"));

	}

}
