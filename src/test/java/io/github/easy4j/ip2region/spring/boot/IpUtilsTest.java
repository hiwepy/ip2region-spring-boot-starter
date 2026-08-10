package io.github.easy4j.ip2region.spring.boot;

import io.github.easy4j.ip2region.spring.boot.util.IpUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link IpUtils}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class IpUtilsTest {

    @Test
    public void isIpv4WithValidIp() {
        assertThat(IpUtils.isIpv4("192.168.1.1")).isTrue();
        assertThat(IpUtils.isIpv4("0.0.0.0")).isTrue();
        assertThat(IpUtils.isIpv4("255.255.255.255")).isTrue();
        assertThat(IpUtils.isIpv4("127.0.0.1")).isTrue();
    }

    @Test
    public void isIpv4WithInvalidIp() {
        assertThat(IpUtils.isIpv4("256.1.1.1")).isFalse();
        assertThat(IpUtils.isIpv4("1.1.1")).isFalse();
        assertThat(IpUtils.isIpv4("abc.def.ghi.jkl")).isFalse();
        assertThat(IpUtils.isIpv4("")).isFalse();
    }

    @Test
    public void isIpv6WithValidIp() {
        assertThat(IpUtils.isIpv6("fe80:1295:8030:1fc6:57fa:0000:0000:1fc6")).isTrue();
        assertThat(IpUtils.isIpv6("fe80:1295:8030:1fc6:57fa:0000:0000:8030")).isTrue();
        assertThat(IpUtils.isIpv6("2001:0db8:85a3:0000:0000:8a2e:0370:7334")).isTrue();
    }

    @Test
    public void isIpv6WithInvalidIp() {
        assertThat(IpUtils.isIpv6("192.168.2.10")).isFalse();
        assertThat(IpUtils.isIpv6("1610329044")).isFalse();
        assertThat(IpUtils.isIpv6("")).isFalse();
    }
}
