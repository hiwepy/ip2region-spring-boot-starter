package com.github.vindell.ip2region.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(IP2regionProperties.PREFIX)
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
	 * total header data block size, must be times of 8; default 8192
	 */
	private int totalHeaderSize = 8192;
	/**
	 * max index data block size u should always choice the fastest read block
	 * size;default 4 * 1024 = 4096
	 */
	private int indexBlockSize = 4096;

	public boolean isExternal() {
		return external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTotalHeaderSize() {
		return totalHeaderSize;
	}

	public void setTotalHeaderSize(int totalHeaderSize) {
		this.totalHeaderSize = totalHeaderSize;
	}

	public int getIndexBlockSize() {
		return indexBlockSize;
	}

	public void setIndexBlockSize(int indexBlockSize) {
		this.indexBlockSize = indexBlockSize;
	}

}