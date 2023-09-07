package com.github.hiwepy.ip2region.spring.boot;

import com.github.hiwepy.ip2region.spring.boot.ext.XdbSearcher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * ip 解析
 */
@Configuration
@ConditionalOnClass(org.lionsoul.ip2region.xdb.Searcher.class)
@EnableConfigurationProperties({ IP2regionProperties.class })
public class IP2regionAutoConfiguration implements ResourceLoaderAware {

	protected ResourceLoader resourceLoader;

	@Bean
	public XdbSearcher xdbSearcher(IP2regionProperties properties) throws IOException {
		if (properties.isExternal()) {
			return new XdbSearcher(resourceLoader, properties.getLocation());
		}
		return new XdbSearcher(resourceLoader);
	}

	@Bean
	public IP2regionTemplate ip2regionTemplate(XdbSearcher xdbSearcher) throws IOException {
		return new IP2regionTemplate(xdbSearcher);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}


}
