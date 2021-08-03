package com.github.hiwepy.ip2region.spring.boot;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.nutz.plugins.ip2region.DBReader;
import org.nutz.plugins.ip2region.DbConfig;
import org.nutz.plugins.ip2region.DbMakerConfigException;
import org.nutz.plugins.ip2region.DbSearcher;
import org.nutz.plugins.ip2region.impl.ByteArrayDBReader;
import org.nutz.plugins.ip2region.impl.RandomAccessFileDBReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

/**
 * 
 */
@Configuration
@ConditionalOnClass(org.nutz.plugins.ip2region.DbSearcher.class)
@EnableConfigurationProperties({ IP2regionProperties.class })
public class IP2regionAutoConfiguration implements ResourceLoaderAware {

	private ResourceLoader resourceLoader;
	
	@Autowired
	private IP2regionProperties properties;
	
	@Bean
	public IP2regionTemplate ip2regionTemplate() throws IOException, DbMakerConfigException {
		
		DbSearcher dbSearcher = null;
		if(properties.isExternal()) {
			
			DBReader reader = null;
			// 查找resource
			Resource resource = resourceLoader.getResource("file:/" + properties.getLocation());
			
			if(resource.isFile() && resource.exists()) {
				
				reader = new RandomAccessFileDBReader(new RandomAccessFile(resource.getFile(), "r"));
				
			} else {
				
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				FileCopyUtils.copy(resource.getInputStream(), output);
				reader = new ByteArrayDBReader(output.toByteArray());
				
			}
			
			DbConfig dbConfig = new DbConfig(properties.getTotalHeaderSize());
			dbConfig.setIndexBlockSize(properties.getIndexBlockSize());
			dbSearcher = new DbSearcher(dbConfig, reader);
			
		} else {
			dbSearcher = new DbSearcher();
		}
		
		return new IP2regionTemplate(dbSearcher);  
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

}
