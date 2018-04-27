package com.github.vindell.ip2region.spring.boot;

import java.io.IOException;

import org.junit.Test;
import org.nutz.plugins.ip2region.DbSearcher;

public class DbSearcher_Test {  
 
   @Test  
   public void searcherTest() throws IOException {
	   
	   DbSearcher searcher = new DbSearcher();
	   
	   System.out.println( searcher.binarySearch("127.0.0.1"));
	   
		for (int i = 0; i < 1000; i++) {
			new Thread() {

				public void run() {

					try {
						System.out.println(searcher.binarySearch("127.0.0.1"));
					} catch (IOException e) {
						e.printStackTrace();
					}

				};

			}.run();
		}

		
   }  
   
}  