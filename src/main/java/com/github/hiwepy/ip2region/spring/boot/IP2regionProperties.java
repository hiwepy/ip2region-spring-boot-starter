package com.github.hiwepy.ip2region.spring.boot;

import com.github.hiwepy.ip2region.spring.boot.ext.XdbSearcher;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(IP2regionProperties.PREFIX)
@Data
public class IP2regionProperties {

	public static final String PREFIX = "ip2region";

	/**
	 * 是否使用外部的IP数据文件.
	 */
	private boolean external = false;
	/**
	 * ip2region.xdb 文件路径，默认： classpath:ip2region/ip2region.xdb
	 */
	private String location = XdbSearcher.DEFAULT_LOCATION;

}