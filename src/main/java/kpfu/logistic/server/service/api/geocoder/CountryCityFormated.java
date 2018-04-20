/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder;

/**
 *
 * @author rz
 */
public class CountryCityFormated {
    
    private String country;
    
    private String city;

    public CountryCityFormated(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public CountryCityFormated() {
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
    public String toString() {
        return "CountryCityFormated{" + "country=" + country + ", city=" + city + '}';
    }
    
    
    
}
