package com.github.hiwepy.ip2region.spring.boot;

import java.io.IOException;

import org.junit.Test;
import org.nutz.plugins.ip2region.DbSearcher;

public class DbSearcher_Test {  
 
   @Test  
   public void searcherTest() throws IOException {
	   
	   DbSearcher searcher = new DbSearcher();
	   
	   System.out.println( searcher.btreeSearch("101.105.35.57"));
	   System.out.println( searcher.binarySearch("101.105.35.57"));
	   System.out.println( searcher.memorySearch("101.105.35.57"));
	   
		for (int i = 1; i < 255; i++) {

			try {
				System.out.println(searcher.binarySearch("115.204.25." + i));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		
   }  
   
}  