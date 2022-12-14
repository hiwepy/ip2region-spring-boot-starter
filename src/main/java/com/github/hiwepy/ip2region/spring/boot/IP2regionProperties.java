package com.github.hiwepy.ip2region.spring.boot;

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
	 * ip2region.db 文件路径，默认： classpath:ip2region/ip2region.db
	 */
	private String location = "classpath:ip2region/ip2region.db";
	/**
	 * ip2region.db 文件路径，默认：tmp/ip2region.xdb
	 */
	private String xdbLocation = "tmp/ip2region.xdb";

	/**
	 * total header data block size, must be times of 8; default 8192
	 */
	private int totalHeaderSize = 8192;
	/**
	 * max index data block size u should always choice the fastest read block
	 * size;default 4 * 1024 = 4096
	 */
	private int indexBlockSize = 4096;

}