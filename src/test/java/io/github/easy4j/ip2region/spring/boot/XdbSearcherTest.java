package io.github.easy4j.ip2region.spring.boot;

import io.github.easy4j.ip2region.spring.boot.ext.XdbSearcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link XdbSearcher}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class XdbSearcherTest {

    private XdbSearcher xdbSearcher;

    private ResourceLoader createResourceLoader() {
        return new ResourceLoader() {
            @Override
            public Resource getResource(String location) {
                return new ClassPathResource("ip2region/ip2region.xdb");
            }
            @Override
            public ClassLoader getClassLoader() {
                return getClass().getClassLoader();
            }
        };
    }

    @BeforeEach
    public void setUp() throws Exception {
        xdbSearcher = new XdbSearcher(createResourceLoader());
    }

    @Test
    public void memorySearchByString() throws Exception {
        String result = xdbSearcher.memorySearch("127.0.0.1");
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }

    @Test
    public void memorySearchByLong() throws Exception {
        String result = xdbSearcher.memorySearch(2130706433L);
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }

    @Test
    public void defaultLocation() {
        assertThat(XdbSearcher.DEFAULT_LOCATION).isEqualTo("classpath:ip2region/ip2region.xdb");
    }

    @Test
    public void notMatchConstant() {
        assertThat(XdbSearcher.NOT_MATCH).isEqualTo("0|0|0|内网IP|内网IP");
    }

    @Test
    public void notMatchRegionAddress() {
        assertThat(XdbSearcher.NOT_MATCH_REGION_ADDRESS).isNotNull();
        assertThat(XdbSearcher.NOT_MATCH_REGION_ADDRESS.getCountry()).isEqualTo("0");
    }

    @Test
    public void setResourceLoader() {
        ResourceLoader newLoader = createResourceLoader();
        xdbSearcher.setResourceLoader(newLoader);
        // should not throw
    }

    @Test
    public void destroyCleansUp() throws Exception {
        xdbSearcher.destroy();
        // should not throw
    }

    @Test
    public void constructorWithCustomLocation() throws Exception {
        XdbSearcher custom = new XdbSearcher(createResourceLoader(), "classpath:ip2region/ip2region.xdb");
        String result = custom.memorySearch("127.0.0.1");
        assertThat(result).isNotNull();
        custom.destroy();
    }
}
