/*
 * Copyright (c) 2018, vindell (https://github.com/vindell).
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
package com.github.vindell.ip2region.spring.boot;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.nutz.plugins.ip2region.DataBlock;
import org.nutz.plugins.ip2region.DbSearcher;
import org.springframework.beans.factory.DisposableBean;

import com.github.vindell.ip2region.spring.boot.ext.RegionAddress;

public class IP2regionTemplate implements DisposableBean {

    protected DbSearcher dbSearcher = null;
    protected ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
 
    public IP2regionTemplate(final DbSearcher dbSearcher) throws IOException {
    	this.dbSearcher = dbSearcher;
    }
    
    /**
     * get the region with a int ip address with memory binary search algorithm
     * @param   ip ： int ip address
     * @return {@link DataBlock} instance
     * @throws  IOException if reader db file error
    */
    public DataBlock memorySearch(long ip) throws IOException {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.memorySearch(ip);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    /**
     * get the region throught the ip address with memory binary search algorithm
     * 
     * @param   ip ： string ip address
     * @return {@link DataBlock} instance
     * @throws  IOException if reader db file error
    */
    public DataBlock memorySearch( String ip ) throws IOException {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.memorySearch(ip);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    
    /**
     * get by index ptr
     * 
     * @param  ptr ： index ptr
     * @return {@link DataBlock} instance
     * @throws  IOException if reader db file error
    */
    public DataBlock getByIndexPtr( long ptr ) throws IOException {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.getByIndexPtr(ptr);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    /**
     * get the region with a int ip address with b-tree algorithm
     * @param   ip ： int ip address
     * @return {@link DataBlock} instance
     * @throws  IOException if reader db file error
    */
    public DataBlock btreeSearch( long ip ) throws IOException {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.btreeSearch(ip);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    /**
     * get the region throught the ip address with b-tree search algorithm
     * @param   ip ： string ip address
     * @return {@link DataBlock} instance
     * @throws  IOException if reader db file error
    */
    public DataBlock btreeSearch( String ip ) throws IOException  {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.btreeSearch(ip);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    /**
     * get the region with a int ip address with binary search algorithm
     * 
     * @param   ip ： int ip address
     * @return {@link DataBlock} instance
     * @throws  IOException if reader db file error
    */
    public DataBlock binarySearch( long ip ) throws IOException {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.binarySearch(ip);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    /**
     * get the region throught the ip address with binary search algorithm
     * @param   ip ： string ip address
     * @return {@link DataBlock} instance
     * @throws  IOException if reader db file error
    */
    public DataBlock binarySearch( String ip ) throws IOException {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.binarySearch(ip);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    public String getRegion(String ip) {
    	try {
    		rwl.readLock().lock();
    		return dbSearcher.getRegion(ip);
    	} finally {
    		rwl.readLock().unlock();
		}
    }
    
    public RegionAddress getRegionAddress(String ip) throws IOException {
    	try {
    		rwl.readLock().lock();
    		return new RegionAddress(dbSearcher.memorySearch(ip).getRegion().split("\\|"));
    	} finally {
    		rwl.readLock().unlock();
		}
    }

	@Override
	public void destroy() throws Exception {
		dbSearcher.close();
	}
    
}
