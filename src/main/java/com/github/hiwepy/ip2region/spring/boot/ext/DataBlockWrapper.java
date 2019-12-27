/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.hiwepy.ip2region.spring.boot.ext;

import org.nutz.plugins.ip2region.DataBlock;

public class DataBlockWrapper {

	private DataBlock block;
	
	/**
	 * region address info
	 */
	private RegionAddress regionAddr;
	
	public static DataBlockWrapper wrapper(DataBlock block) {
		return new DataBlockWrapper(block);
	}

	private DataBlockWrapper(DataBlock block) {
		this.block = block;
		this.regionAddr = new RegionAddress(block.getRegion().split("\\|"));
	}

	public int getCityId() {
		return block.getCityId();
	}

	public DataBlock setCityId(int city_id) {
		block.setCityId(city_id);
		return block;
	}

	public String getRegion() {
		return block.getRegion();
	}

	public DataBlock setRegion(String region) {
		this.block.setRegion(region);
		return block;
	}

	public int getDataPtr() {
		return block.getDataPtr();
	}

	public DataBlock setDataPtr(int dataPtr) {
		block.setDataPtr(dataPtr);
		return block;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(block.getCityId()).append('|').append(block.getRegion()).append('|').append(block.getDataPtr());
		return sb.toString();
	}

	public RegionAddress getRegionAddr() {
		return regionAddr;
	}

	public void setRegionAddr(RegionAddress regionAddr) {
		this.regionAddr = regionAddr;
	}

}
