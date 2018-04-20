package kpfu.logistic.server.service.api.storage;

import java.util.Objects;

public class CountryCity {

    private String country;

    private String city;

    public CountryCity() {
    }

    public CountryCity(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCity that = (CountryCity) o;
        return Objects.equals(country, that.country) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(country, city);
    }

    @Override
    public String toString() {
        return "CountryCity{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
