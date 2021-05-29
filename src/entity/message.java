package entity;

import java.util.Objects;

public class message {
    private Integer id;
    private Integer sno;
    private String name;
    private String sex;
    private String province;
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        message message = (message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(sno, message.sno) &&
                Objects.equals(name, message.name) &&
                Objects.equals(sex, message.sex) &&
                Objects.equals(province, message.province) &&
                Objects.equals(city, message.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sno, name, sex, province, city);
    }

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", sno=" + sno +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public message(Integer id, Integer sno, String name, String sex, String province, String city) {
        this.id = id;
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.province = province;
        this.city = city;
    }

    public message() {
    }
}
