package io.github.easy4j.ip2region.spring.boot;

import io.github.easy4j.ip2region.spring.boot.ext.RegionAddress;
import io.github.easy4j.ip2region.spring.boot.ext.RegionEnum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RegionEnum}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class RegionEnumTest {

    @Test
    public void getByNumberFound() {
        assertThat(RegionEnum.getByNumber("156")).isEqualTo(RegionEnum.CN);
        assertThat(RegionEnum.getByNumber("840")).isEqualTo(RegionEnum.US);
    }

    @Test
    public void getByNumberNotFound() {
        assertThat(RegionEnum.getByNumber("000")).isEqualTo(RegionEnum.UK);
    }

    @Test
    public void getByCode2Found() {
        assertThat(RegionEnum.getByCode2("CN")).isEqualTo(RegionEnum.CN);
        assertThat(RegionEnum.getByCode2("US")).isEqualTo(RegionEnum.US);
        assertThat(RegionEnum.getByCode2("cn")).isEqualTo(RegionEnum.CN);
    }

    @Test
    public void getByCode2NotFound() {
        assertThat(RegionEnum.getByCode2("XX")).isEqualTo(RegionEnum.UK);
    }

    @Test
    public void getByCode3Found() {
        assertThat(RegionEnum.getByCode3("CHN")).isEqualTo(RegionEnum.CN);
        assertThat(RegionEnum.getByCode3("USA")).isEqualTo(RegionEnum.US);
    }

    @Test
    public void getByCode3NotFound() {
        assertThat(RegionEnum.getByCode3("XXX")).isEqualTo(RegionEnum.UK);
    }

    @Test
    public void getByIsoCodeFound() {
        assertThat(RegionEnum.getByIsoCode("ISO 3166-2:CN")).isEqualTo(RegionEnum.CN);
    }

    @Test
    public void getByIsoCodeNotFound() {
        assertThat(RegionEnum.getByIsoCode("INVALID")).isEqualTo(RegionEnum.UK);
    }

    @Test
    public void getByIsoNameFound() {
        assertThat(RegionEnum.getByIsoName("China")).isEqualTo(RegionEnum.CN);
    }

    @Test
    public void getByIsoNameNotFound() {
        assertThat(RegionEnum.getByIsoName("NonExistent")).isEqualTo(RegionEnum.UK);
    }

    @Test
    public void getByCnNameFound() {
        assertThat(RegionEnum.getByCnName("中国")).isEqualTo(RegionEnum.CN);
        assertThat(RegionEnum.getByCnName("美国")).isEqualTo(RegionEnum.US);
    }

    @Test
    public void getByCnNameNotFound() {
        assertThat(RegionEnum.getByCnName("不存在")).isEqualTo(RegionEnum.UK);
    }

    @Test
    public void getByRegionAddressFound() {
        RegionAddress address = new RegionAddress("中国", "江苏省", "南京市", "华东", "电信");
        assertThat(RegionEnum.getByRegionAddress(address)).isEqualTo(RegionEnum.CN);
    }

    @Test
    public void getByRegionAddressNotFound() {
        RegionAddress address = new RegionAddress("不存在", "不存在", "不存在", "不存在", "不存在");
        assertThat(RegionEnum.getByRegionAddress(address)).isEqualTo(RegionEnum.UK);
    }

    @Test
    public void isValidRegionWithValid() {
        assertThat(RegionEnum.isValidRegion(RegionEnum.CN)).isTrue();
        assertThat(RegionEnum.isValidRegion(RegionEnum.US)).isTrue();
    }

    @Test
    public void isValidRegionWithInvalid() {
        assertThat(RegionEnum.isValidRegion(RegionEnum.UK)).isFalse();
        assertThat(RegionEnum.isValidRegion(RegionEnum.TS)).isFalse();
    }

    @Test
    public void isChinaRegionStatic() {
        assertThat(RegionEnum.isChinaRegion(RegionEnum.CN)).isTrue();
        assertThat(RegionEnum.isChinaRegion(RegionEnum.HK)).isTrue();
        assertThat(RegionEnum.isChinaRegion(RegionEnum.MO)).isTrue();
        assertThat(RegionEnum.isChinaRegion(RegionEnum.TW)).isTrue();
        assertThat(RegionEnum.isChinaRegion(RegionEnum.US)).isFalse();
    }

    @Test
    public void isChinaRegionByCode() {
        assertThat(RegionEnum.isChinaRegion("CN")).isTrue();
        assertThat(RegionEnum.isChinaRegion("HK")).isTrue();
        assertThat(RegionEnum.isChinaRegion("CHN")).isTrue();
        assertThat(RegionEnum.isChinaRegion("US")).isFalse();
    }

    @Test
    public void isMainlandWithCode() {
        assertThat(RegionEnum.isMainland("CN")).isTrue();
        assertThat(RegionEnum.isMainland("HK")).isFalse();
        assertThat(RegionEnum.isMainland("US")).isFalse();
    }

    @Test
    public void instanceMethods() {
        assertThat(RegionEnum.CN.isValidRegion()).isTrue();
        assertThat(RegionEnum.UK.isValidRegion()).isFalse();
        assertThat(RegionEnum.CN.isChinaRegion()).isTrue();
        assertThat(RegionEnum.US.isChinaRegion()).isFalse();
        assertThat(RegionEnum.CN.isChinaMainland()).isTrue();
        assertThat(RegionEnum.HK.isChinaMainland()).isFalse();
    }

    @Test
    public void equalsMethod() {
        assertThat(RegionEnum.CN.equals(RegionEnum.CN)).isTrue();
        assertThat(RegionEnum.CN.equals(RegionEnum.US)).isFalse();
    }

    @Test
    public void getters() {
        RegionEnum cn = RegionEnum.CN;
        assertThat(cn.getNumber()).isEqualTo("156");
        assertThat(cn.getCode2()).isEqualTo("CN");
        assertThat(cn.getCode3()).isEqualTo("CHN");
        assertThat(cn.getIsoCode()).isEqualTo("ISO 3166-2:CN");
        assertThat(cn.getIsoName()).isEqualTo("China");
        assertThat(cn.getCname()).isEqualTo("中国");
    }

    @Test
    public void valuesNotEmpty() {
        assertThat(RegionEnum.values()).isNotEmpty();
        assertThat(RegionEnum.values().length).isGreaterThan(200);
    }
}
