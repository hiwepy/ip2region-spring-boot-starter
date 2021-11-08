package com.github.hiwepy.ip2region.spring.boot.util;

import java.util.regex.Pattern;

public class IpUtils {

    protected static Pattern IPV4 = Pattern.compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
    protected static Pattern IPV6 = Pattern.compile("^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    public static boolean isIpv4(String ip4){
        return IPV4.matcher(ip4).matches();
    }

    public static boolean isIpv6(String ip6){
        return IPV6.matcher(ip6).matches();
    }

    public static void main(String[] args) {
        System.out.println(IpUtils.isIpv6("1610329044 "));
        System.out.println(IpUtils.isIpv6("192.168.2.10"));
        System.out.println(IpUtils.isIpv6("fe80:1295:8030:1fc6:57fa:0000:0000:1fc6"));
        System.out.println(IpUtils.isIpv6("fe80:1295:8030:1fc6:57fa:0000:0000:8030"));
    }

}
