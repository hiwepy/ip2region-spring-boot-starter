package io.github.easy4j.ip2region.spring.boot;

import io.github.easy4j.ip2region.spring.boot.ext.RegionAddress;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RegionAddress}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class RegionAddressTest {

    @Test
    public void defaultConstructor() {
        RegionAddress address = new RegionAddress();
        assertThat(address.getCountry()).isNull();
        assertThat(address.getProvince()).isNull();
        assertThat(address.getCity()).isNull();
        assertThat(address.getArea()).isNull();
        assertThat(address.getISP()).isNull();
    }

    @Test
    public void arrayConstructor() {
        String[] region = {"中国", "华东", "江苏省", "南京市", "电信"};
        RegionAddress address = new RegionAddress(region);
        assertThat(address.getCountry()).isEqualTo("中国");
        assertThat(address.getProvince()).isEqualTo("江苏省");
        assertThat(address.getCity()).isEqualTo("南京市");
        assertThat(address.getArea()).isEqualTo("华东");
        assertThat(address.getISP()).isEqualTo("电信");
    }

    @Test
    public void fullConstructor() {
        RegionAddress address = new RegionAddress("中国", "江苏省", "南京市", "华东", "电信");
        assertThat(address.getCountry()).isEqualTo("中国");
        assertThat(address.getProvince()).isEqualTo("江苏省");
        assertThat(address.getCity()).isEqualTo("南京市");
        assertThat(address.getArea()).isEqualTo("华东");
        assertThat(address.getISP()).isEqualTo("电信");
    }

    @Test
    public void settersAndGetters() {
        RegionAddress address = new RegionAddress();
        address.setCountry("美国");
        address.setProvince("加州");
        address.setCity("洛杉矶");
        address.setArea("西海岸");
        address.setISP("AT&T");

        assertThat(address.getCountry()).isEqualTo("美国");
        assertThat(address.getProvince()).isEqualTo("加州");
        assertThat(address.getCity()).isEqualTo("洛杉矶");
        assertThat(address.getArea()).isEqualTo("西海岸");
        assertThat(address.getISP()).isEqualTo("AT&T");
    }

    @Test
    public void toStringContainsFields() {
        RegionAddress address = new RegionAddress("中国", "江苏省", "南京市", "华东", "电信");
        String str = address.toString();
        assertThat(str).contains("中国");
        assertThat(str).contains("江苏省");
        assertThat(str).contains("南京市");
        assertThat(str).contains("华东");
        assertThat(str).contains("电信");
    }
}
