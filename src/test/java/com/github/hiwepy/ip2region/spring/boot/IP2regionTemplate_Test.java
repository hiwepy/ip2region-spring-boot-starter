package com.github.hiwepy.ip2region.spring.boot;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.nutz.plugins.ip2region.DbSearcher;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;

public class IP2regionTemplate_Test {

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");

	@Test
	public void templateTest() throws IOException {

		DbSearcher searcher = new DbSearcher();

		IP2regionTemplate template = new IP2regionTemplate(searcher);

		System.out.println(template.getCountryByIp("127.0.0.1"));


		System.out.println(template.getRegion("114.44.227.87"));

		RegionAddress adress1 = template.getRegionAddress("13.228.204.118");
		System.out.println(adress1);
		System.out.println(RegionEnum.getByRegionAddress(adress1));

		RegionAddress adress2 = template.getRegionAddress("127.0.0.1");
		System.out.println(adress2);
		System.out.println(RegionEnum.getByRegionAddress(adress2));

		RegionEnum regionEnum = template.getRegionByIp("13.228.204.118");

		System.out.println(template.binarySearch("127.0.0.1"));

		for (int i = 0; i < 1000; i++) {
			try {
				System.out.println(df.format(new Date()) + ":" + template.binarySearch("127.0.0.1"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
