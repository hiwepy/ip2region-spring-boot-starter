package com.github.hiwepy.ip2region.spring.boot;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import org.lionsoul.ip2region.xdb.Searcher;
import org.nutz.plugins.ip2region.DBReader;
import org.nutz.plugins.ip2region.DbConfig;
import org.nutz.plugins.ip2region.DbMakerConfigException;
import org.nutz.plugins.ip2region.DbSearcher;
import org.nutz.plugins.ip2region.impl.ByteArrayDBReader;
import org.nutz.plugins.ip2region.impl.RandomAccessFileDBReader;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

/**
 * ip 解析
 */
@Configuration
@ConditionalOnClass(org.nutz.plugins.ip2region.DbSearcher.class)
@EnableConfigurationProperties({ IP2regionProperties.class })
public class IP2regionAutoConfiguration implements ResourceLoaderAware {

	protected ResourceLoader resourceLoader = new PathMatchingResourcePatternResolver();

	@Bean
	public IP2regionTemplate ip2regionTemplate(IP2regionProperties properties) throws IOException, DbMakerConfigException {

		DbSearcher dbSearcher = null;
		if(properties.isExternal()) {

			DbConfig dbConfig = new DbConfig(properties.getTotalHeaderSize());
			dbConfig.setIndexBlockSize(properties.getIndexBlockSize());
			try {
				if(new File(properties.getLocation()).exists()) {
					// load ip2region.db from java.nio.file.Path
					DBReader reader = new ByteArrayDBReader(Files.readAllBytes(Paths.get(properties.getLocation())));
					dbSearcher = new DbSearcher(dbConfig, reader);
				} else {
					// 查找resource
					Resource resource = resourceLoader.getResource(properties.getLocation());
					try(ByteArrayOutputStream output = new ByteArrayOutputStream();) {
						FileCopyUtils.copy(resource.getInputStream(), output);
						DBReader reader = new ByteArrayDBReader(output.toByteArray());
						dbSearcher = new DbSearcher(dbConfig, reader);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				dbSearcher = new DbSearcher();
			}
		} else {
			dbSearcher = new DbSearcher();
		}
		return new IP2regionTemplate(dbSearcher);
	}

	@Bean
	public IP2regionXdbTemplate ip2regionXdbTemplate(IP2regionProperties properties) throws IOException {
		return new IP2regionXdbTemplate(properties.getXdbLocation());
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

}
