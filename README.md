# ip2region-spring-boot-starter
Spring Boot Starter For ip2region

### 说明


 > 基于 ip2region 的 Spring Boot Starter 实现

1. 最新IP数据下载地址： https://github.com/lionsoul2014/ip2region

### Maven

``` xml
<dependency>
	<groupId>com.github.hiwepy</groupId>
	<artifactId>ip2region-spring-boot-starter</artifactId>
	<version>${project.version}</version>
</dependency>
```

### Sample

```java

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableIP2region
@SpringBootApplication
public class Application {
	
	@Autowired
	IP2regionTemplate template;
	
	@PostConstruct
	public void test() throws IOException {
		
		System.out.println(template.binarySearch("127.0.0.1"));
		System.out.println(template.binarySearch("127.0.0.1"));
		
	}
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}

```

如果使用外部IP数据，可自定义配置，参考如下：
```yaml
ip2region:
  external: false
  index-block-size: 4096
  total-header-size: 8192
  location: classpath:ip2region/ip2region.db
```

