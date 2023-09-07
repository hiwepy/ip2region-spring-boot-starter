package com.github.hiwepy.ip2region.spring.boot.ext;

import com.github.hiwepy.ip2region.spring.boot.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * https://github.com/lionsoul2014/ip2region/tree/master/binding/java
 */
@Slf4j
public class XdbSearcher implements ResourceLoaderAware, DisposableBean {

    public static final String NOT_MATCH = "0|0|0|内网IP|内网IP";
    public static final RegionAddress NOT_MATCH_REGION_ADDRESS = new RegionAddress(NOT_MATCH.split("\\|"));
    public static final String DEFAULT_LOCATION = "classpath:ip2region/ip2region.xdb";
    protected ResourceLoader resourceLoader;
    protected byte[] vIndex;
    protected byte[] xdbBuff;
    protected Searcher searcher = null;

    public XdbSearcher(ResourceLoader resourceLoader) throws IOException {
        this.resourceLoader = resourceLoader;
        this.searcher = this.loadWithBuffer(DEFAULT_LOCATION);
    }

    public XdbSearcher(ResourceLoader resourceLoader, String location) throws IOException {
        this.resourceLoader = resourceLoader;
        this.searcher = this.loadWithBuffer(location);
    }

    /**
     * 缓存整个 xdb 数据 （推荐）
     * 1、创建 searcher 对象
     * 2、加载数据
     * 3、关闭 searcher 对象
     * @param location
     * @throws IOException
     */
    public synchronized Searcher loadWithBuffer(String location) throws IOException {
        // 1、从 dbPath 加载整个 xdb 到内存。
        if (Objects.isNull(xdbBuff)) {
            try {
                if(new File(location).exists()) {
                    // load ip2region.db from java.nio.file.Path
                    xdbBuff = Searcher.loadContentFromFile(location);
                } else {
                    // 查找resource
                    Resource resource = resourceLoader.getResource(location);
                    try(ByteArrayOutputStream output = new ByteArrayOutputStream();) {
                        FileCopyUtils.copy(resource.getInputStream(), output);
                        xdbBuff = output.toByteArray();
                    }
                }
            } catch (Exception e) {
                log.error(String.format("failed to load content from `%s`: \n", location), e);
            }
        }
        // 2、使用上述的 xdbBuff 创建一个完全基于内存的查询对象。
        Searcher searcher = null;
        if (Objects.nonNull(xdbBuff)) {
            try {
                searcher = Searcher.newWithBuffer(xdbBuff);
            } catch (Exception e) {
                log.error("failed to create content cached searcher: \n", e);
            }
        }
        return searcher;
    }

    /**
     * get the region with a int ip address with memory binary search algorithm
     *
     * @param   ip
     * @throws IOException
     */
    public String memorySearch(long ip) throws IOException {
        if(Objects.isNull(xdbBuff) || Objects.isNull(searcher)){
            return NOT_MATCH;
        }
        long sTime = System.nanoTime();
        String region = searcher.search(ip);
        long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
        log.info(" IP : {} >> region: {}, ioCount: {}, took: {} μs \n", Searcher.long2ip(ip), region, searcher.getIOCount(), cost);
        // not matched
        if (!StringUtils.hasText(region)) {
            return NOT_MATCH;
        }
        return region;
    }

    /**
     * get the region throught the ip address with memory binary search algorithm
     *
     * @param   ip
     * @return  DataBlock
     * @throws  IOException
     */
    public String memorySearch(String ip) throws IOException {
        return memorySearch(Util.ip2long(ip));
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void destroy() throws Exception {
        if(Objects.nonNull(searcher)){
            searcher.close();
        }
    }
}
