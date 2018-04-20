/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder;

import java.util.Objects;

/**
 *
 * @author rz
 */
public class CountryCityRaw {
    
    private String country;
    
    private String city;

    public CountryCityRaw() {
        this.city = "";
        this.country = "";
    }

    public CountryCityRaw(String country, String city) {
        this.country = country;
        this.city = city;
        
        if (this.country == null) {
            this.country = "";
        }
        
        if (this.city == null) {
            this.city = "";
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        if (this.country == null) {
            this.country = "";
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        if (this.city == null) {
            this.city = "";
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.country.toLowerCase().trim());
        hash = 71 * hash + Objects.hashCode(this.city.toLowerCase().trim());
        return hash;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CountryCityRaw other = (CountryCityRaw) obj;
        
        if (!Objects.equals(this.country.toLowerCase().trim(), other.country.toLowerCase().trim())) {
            return false;
        }
        if (!Objects.equals(this.city.toLowerCase().trim(), other.city.toLowerCase().trim())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CountryCityRaw{" + "country=" + country + ", city=" + city + '}';
    }
    
    
    
    
    
}
