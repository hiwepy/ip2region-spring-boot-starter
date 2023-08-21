# ip2region-spring-boot-starter

Spring Boot Starter For ip2region

### 组件简介

 > 基于 ip2region 的 Spring Boot Starter 实现

1. 最新IP数据下载地址： https://github.com/lionsoul2014/ip2region

### 使用说明

##### 1、Spring Boot 项目添加 Maven 依赖

``` xml
<dependency>
	<groupId>com.github.hiwepy</groupId>
	<artifactId>ip2region-spring-boot-starter</artifactId>
	<version>${project.version}</version>
</dependency>
```

##### 2、在`application.yml`文件中增加如下配置（默认不需要添加）

如果使用外部IP数据，可自定义配置，参考如下：

```yaml
ip2region:
  external: false
  location: classpath*:ip2region/ip2region.db
```


##### 3、使用示例

```java

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Autowired
    IP2regionTemplate template;

    @PostConstruct
    public void test() throws IOException {

        System.out.println( template.memorySearch("61.94.43.82"));
        System.out.println(template.memorySearch("127.0.0.1"));

        // 根据IP获取对应国家
        System.out.println(template.getCountryByIp("127.0.0.1"));

        // 根据IP获取对应地区
        System.out.println(template.getRegion("114.124.146.103"));

        // 根据IP获取对应地区详细信息对象
        RegionAddress adress1 = template.getRegionAddress("113.210.53.80");
        System.out.println(adress1);
        System.out.println(RegionEnum.getByRegionAddress(adress1));

        // 根据IP获取对应地区枚举
        RegionEnum regionEnum = template.getRegionByIp("102.42.140.162");
        System.out.println(regionEnum);

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}

```


## Jeebiz 技术社区

Jeebiz 技术社区 **微信公共号**、**小程序**，欢迎关注反馈意见和一起交流，关注公众号回复「Jeebiz」拉你入群。

|公共号|小程序|
|---|---|
| ![](https://raw.githubusercontent.com/hiwepy/static/main/images/qrcode_for_gh_1d965ea2dfd1_344.jpg)| ![](https://raw.githubusercontent.com/hiwepy/static/main/images/gh_09d7d00da63e_344.jpg)|

