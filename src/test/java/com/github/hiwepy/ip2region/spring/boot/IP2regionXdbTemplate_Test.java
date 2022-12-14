package com.github.hiwepy.ip2region.spring.boot;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import org.junit.Before;
import org.junit.Test;
import org.nutz.plugins.ip2region.DBReader;
import org.nutz.plugins.ip2region.DbConfig;
import org.nutz.plugins.ip2region.DbSearcher;
import org.nutz.plugins.ip2region.impl.ByteArrayDBReader;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;

public class IP2regionXdbTemplate_Test {

	IP2regionXdbTemplate template = null;

	@Before
	public void setUp()  throws Exception {
		String dbPath = "D:\\tmp\\ip2region-2.11.0\\data\\ip2region.xdb";
		template = new IP2regionXdbTemplate(dbPath);
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
