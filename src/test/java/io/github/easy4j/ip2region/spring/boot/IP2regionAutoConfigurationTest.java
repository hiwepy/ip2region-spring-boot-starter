package io.github.easy4j.ip2region.spring.boot;

import io.github.easy4j.ip2region.spring.boot.ext.XdbSearcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link IP2regionAutoConfiguration} and {@link IP2regionProperties}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class IP2regionAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(IP2regionAutoConfiguration.class));

    @Test
    public void defaultProperties() {
        this.contextRunner.run(context -> {
            assertThat(context).hasSingleBean(IP2regionProperties.class);
            IP2regionProperties props = context.getBean(IP2regionProperties.class);
            assertThat(props.isExternal()).isFalse();
            assertThat(props.getLocation()).isEqualTo("classpath:ip2region/ip2region.xdb");
        });
    }

    @Test
    public void customProperties() {
        this.contextRunner
                .withPropertyValues("ip2region.external=true", "ip2region.location=classpath:ip2region/ip2region.xdb")
                .run(context -> {
                    assertThat(context).hasSingleBean(IP2regionProperties.class);
                    IP2regionProperties props = context.getBean(IP2regionProperties.class);
                    assertThat(props.isExternal()).isTrue();
                    assertThat(props.getLocation()).isEqualTo("classpath:ip2region/ip2region.xdb");
                });
    }

    @Test
    public void beansCreated() {
        this.contextRunner.run(context -> {
            assertThat(context).hasSingleBean(XdbSearcher.class);
            assertThat(context).hasSingleBean(IP2regionTemplate.class);
        });
    }

    @Test
    public void propertiesSettersWork() {
        IP2regionProperties props = new IP2regionProperties();
        props.setExternal(true);
        props.setLocation("custom-location");
        assertThat(props.isExternal()).isTrue();
        assertThat(props.getLocation()).isEqualTo("custom-location");
    }
}
