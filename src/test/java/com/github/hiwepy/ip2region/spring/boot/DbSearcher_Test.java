package com.github.hiwepy.ip2region.spring.boot;

import java.io.IOException;

import org.junit.Test;
import org.nutz.plugins.ip2region.DbSearcher;

public class DbSearcher_Test {  
 
   @Test  
   public void searcherTest() throws IOException {
	   
	   DbSearcher searcher = new DbSearcher();
	   
	   System.out.println( searcher.btreeSearch("61.94.43.82"));
	   System.out.println( searcher.binarySearch("61.94.43.82"));
	   System.out.println( searcher.memorySearch("61.94.43.82"));
	   
		for (int i = 0; i < 10; i++) {
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