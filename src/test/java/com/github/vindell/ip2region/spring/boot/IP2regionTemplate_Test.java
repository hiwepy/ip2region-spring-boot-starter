package com.github.vindell.ip2region.spring.boot;

import java.io.IOException;

import org.junit.Test;
import org.nutz.plugins.ip2region.DbSearcher;

import com.github.vindell.ip2region.spring.boot.IP2regionTemplate;

public class IP2regionTemplate_Test {

	@Test
	public void templateTest() throws IOException {

		DbSearcher searcher = new DbSearcher();

		IP2regionTemplate template = new IP2regionTemplate(searcher);

		System.out.println(template.binarySearch("127.0.0.1"));
		
		for (int i = 0; i < 100; i++) {
			new Thread() {

				public void run() {

					try {
						System.out.println(template.binarySearch("127.0.0.1"));
					} catch (IOException e) {
						e.printStackTrace();
					}

				};

			}.run();
		}

	}

}