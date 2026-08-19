package io.github.easy4j.ip2region.spring.boot.ext;

/**
 * Basic RegionAddress Info
 * @author 凡梦星尘(elkan1788@gmail.com)
 * @since 1.0.0
 */
public class RegionAddress {

    private String country;
    private String province;
    private String city;
    private String area;
    private String ISP;

    public RegionAddress() {
    }

    /**
     *
     * Translate this string "中国|华东|江苏省|南京市|电信" or "印度尼西亚|0|大雅加达|雅加达|Telin" to location fields.
     * @param region location region address info array
     */
    public RegionAddress(String[] region) {
        this(region[0], region[2], region[3], region[1], region[4]);
    }

    /**
     * Basic constructor method
     * @param country   Country name
     * @param province  province name
     * @param city      city name
     * @param area      area name
     * @param ISP       ISP name
     */
    public RegionAddress(String country, String province, String city, String area, String ISP) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.area = area;
        this.ISP = ISP;
    }
    /** Gets the country. */

    public String getCountry() {
        return country;
    }
    /** Sets the country. */

    public void setCountry(String country) {
        this.country = country;
    }
    /** Gets the province. */

    public String getProvince() {
        return province;
    }
    /** Sets the province. */

    public void setProvince(String province) {
        this.province = province;
    }
    /** Gets the city. */

    public String getCity() {
        return city;
    }
    /** Sets the city. */

    public void setCity(String city) {
        this.city = city;
    }
    /** Gets the area. */

    public String getArea() {
        return area;
    }
    /** Sets the area. */

    public void setArea(String area) {
        this.area = area;
    }
    /** Gets the i s p. */

    public String getISP() {
        return ISP;
    }
    /** Sets the i s p. */

    public void setISP(String ISP) {
        this.ISP = ISP;
    }
    /**
     * <p>To string.</p>
     * @return the string
     */

    @Override
    public String toString() {
        return "RegionAddress{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", ISP='" + ISP + '\'' +
                '}';
    }
}
