package com.github.hiwepy.ip2region.spring.boot;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import com.github.hiwepy.ip2region.spring.boot.ext.XdbSearcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;

public class IP2RegionTemplate_Test {

	IP2regionTemplate template = null;

	@Before
	public void setUp()  throws Exception {
		String dbPath = "D:\\data\\ip2region.xdb";
		ResourceLoader resourceLoader = new FileSystemResourceLoader();
		XdbSearcher xdbSearcher = new XdbSearcher(resourceLoader, dbPath);
		template = new IP2regionTemplate(xdbSearcher);
	}

	@Test
	public void templateTest() throws Exception {

		System.out.println(template.memorySearch("127.0.0.1"));
		System.out.println(template.memorySearch("114.124.146.103"));
		System.out.println(template.memorySearch("115.193.169.84"));

		System.out.println(template.getRegion("127.0.0.1"));
		System.out.println(template.getRegion("114.124.146.103"));

		RegionAddress adress1 = template.getRegionAddress("125.119.96.60");
		System.out.println(adress1);
		System.out.println(RegionEnum.getByRegionAddress(adress1));

		RegionAddress adress2 = template.getRegionAddress("127.0.0.1");
		System.out.println(adress2);
		System.out.println(RegionEnum.getByRegionAddress(adress2));

		RegionEnum regionEnum1 = template.getRegionByIp("127.0.0.1");
		System.out.println(regionEnum1);
		RegionEnum regionEnum2 = template.getRegionByIp("102.42.140.162");
		System.out.println(regionEnum2);

		System.out.println(template.getCountryByIp("127.0.0.1"));
		System.out.println(template.getCountryByIp("114.124.146.103"));

		System.out.println(template.isMainlandIp("127.0.0.1"));
		System.out.println(template.isMainlandIp("114.124.146.103"));

	}

}
