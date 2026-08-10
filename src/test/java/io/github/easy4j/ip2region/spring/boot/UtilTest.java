package io.github.easy4j.ip2region.spring.boot;

import io.github.easy4j.ip2region.spring.boot.util.Util;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Util}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class UtilTest {

    @Test
    public void writeAndGetIntLong() {
        byte[] b = new byte[4];
        Util.writeIntLong(b, 0, 0x04030201L);
        assertThat(Util.getIntLong(b, 0)).isEqualTo(0x04030201L);
    }

    @Test
    public void writeAndGetIntLongWithOffset() {
        byte[] b = new byte[8];
        Util.writeIntLong(b, 2, 0x0A0B0C0DL);
        assertThat(Util.getIntLong(b, 2)).isEqualTo(0x0A0B0C0DL);
    }

    @Test
    public void getInt3AllFF() {
        byte[] b = new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        int result = Util.getInt3(b, 0);
        assertThat(result).isEqualTo(0xFFFFFF);
    }

    @Test
    public void getInt3SingleByte() {
        // Only first byte has value < 0x80; other bytes are 0
        byte[] b = new byte[]{0x01, 0x00, 0x00};
        int result = Util.getInt3(b, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getInt3WithOffset() {
        byte[] b = new byte[]{0x01, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        int result = Util.getInt3(b, 1);
        assertThat(result).isEqualTo(0xFFFFFF);
    }

    @Test
    public void getInt2AllFF() {
        byte[] b = new byte[]{(byte) 0xFF, (byte) 0xFF};
        int result = Util.getInt2(b, 0);
        assertThat(result).isEqualTo(0xFFFF);
    }

    @Test
    public void getInt2SingleByte() {
        byte[] b = new byte[]{0x01, 0x00};
        int result = Util.getInt2(b, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getInt2WithOffset() {
        byte[] b = new byte[]{0x01, (byte) 0xFF, (byte) 0xFF};
        int result = Util.getInt2(b, 1);
        assertThat(result).isEqualTo(0xFFFF);
    }

    @Test
    public void getInt1() {
        byte[] b = new byte[]{(byte) 0xFF, 0x02};
        assertThat(Util.getInt1(b, 0)).isEqualTo(0xFF);
    }

    @Test
    public void getInt1WithOffset() {
        byte[] b = new byte[]{(byte) 0xFF, 0x42};
        assertThat(Util.getInt1(b, 1)).isEqualTo(0x42);
    }

    @Test
    public void writeWithCustomBytes() {
        byte[] b = new byte[8];
        Util.write(b, 0, 0x0102030405L, 5);
        assertThat(b[0]).isEqualTo((byte) 0x05);
        assertThat(b[1]).isEqualTo((byte) 0x04);
        assertThat(b[2]).isEqualTo((byte) 0x03);
        assertThat(b[3]).isEqualTo((byte) 0x02);
        assertThat(b[4]).isEqualTo((byte) 0x01);
    }

    @Test
    public void writeWithOffset() {
        byte[] b = new byte[8];
        Util.write(b, 2, 0xABL, 1);
        assertThat(b[2]).isEqualTo((byte) 0xAB);
    }

    @Test
    public void ip2longWithValidIp() {
        long ip = Util.ip2long("192.168.1.1");
        assertThat(ip).isGreaterThan(0);
    }

    @Test
    public void ip2longWithInvalidIp() {
        long ip = Util.ip2long("invalid");
        assertThat(ip).isEqualTo(0);
    }

    @Test
    public void long2ip() {
        String ip = Util.long2ip(Util.ip2long("192.168.1.1"));
        assertThat(ip).isEqualTo("192.168.1.1");
    }

    @Test
    public void isIpAddressWithValidIp() {
        assertThat(Util.isIpAddress("192.168.1.1")).isTrue();
        assertThat(Util.isIpAddress("0.0.0.0")).isTrue();
        assertThat(Util.isIpAddress("255.255.255.255")).isTrue();
    }

    @Test
    public void isIpAddressWithInvalidIp() {
        assertThat(Util.isIpAddress("invalid")).isFalse();
        assertThat(Util.isIpAddress("256.1.1.1")).isFalse();
        assertThat(Util.isIpAddress("1.1.1")).isFalse();
    }

    @Test
    public void ip2longAndLong2ipRoundTrip() {
        String[] ips = {"10.0.0.1", "172.16.0.1", "192.168.0.1", "8.8.8.8"};
        for (String ip : ips) {
            long longIp = Util.ip2long(ip);
            assertThat(Util.long2ip(longIp)).isEqualTo(ip);
        }
    }
}
