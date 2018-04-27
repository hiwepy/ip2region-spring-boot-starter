package com.github.vindell.ip2region.spring.boot;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.nutz.plugins.ip2region.DbSearcher;

public class IP2regionTemplate_Test {
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");		
	
	@Test
	public void templateTest() throws IOException {

		DbSearcher searcher = new DbSearcher();

		IP2regionTemplate template = new IP2regionTemplate(searcher);

		
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