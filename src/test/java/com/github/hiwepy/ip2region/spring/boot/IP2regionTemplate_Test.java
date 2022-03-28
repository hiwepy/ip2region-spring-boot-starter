package com.github.hiwepy.ip2region.spring.boot;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.nutz.plugins.ip2region.DBReader;
import org.nutz.plugins.ip2region.DbConfig;
import org.nutz.plugins.ip2region.DbSearcher;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import org.nutz.plugins.ip2region.impl.ByteArrayDBReader;
import org.springframework.util.FileCopyUtils;

public class IP2regionTemplate_Test {

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");

	@Test
	public void templateTest() throws Exception {

		DbConfig dbConfig = new DbConfig(8192);
		dbConfig.setIndexBlockSize(4096);

		// reader = new RandomAccessFileDBReader(new RandomAccessFile(resource.getFile(), "r"));

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		FileCopyUtils.copy(this.getClass().getClassLoader().getResourceAsStream("ip2region_new.db"), output);
		DBReader reader = new ByteArrayDBReader(output.toByteArray());

		DbSearcher searcher = new DbSearcher(dbConfig, reader);

		IP2regionTemplate template = new IP2regionTemplate(searcher);

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

		System.out.println(template.binarySearch("127.0.0.1"));

		/*


		for (int i = 0; i < 1000; i++) {
			new Thread() {

				public void run() {

					try {
						System.out.println(df.format(new Date()) + ":" + template.binarySearch("127.0.0.1"));
					} catch (IOException e) {
						e.printStackTrace();
					}

				};

			}.run();
		}*/

	}

}
