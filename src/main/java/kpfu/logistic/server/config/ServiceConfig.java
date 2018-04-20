package kpfu.logistic.server.config;

import kpfu.logistic.server.service.Crypter;
import kpfu.logistic.server.service.Md5Crypter;
import kpfu.logistic.server.service.api.geocoder.CountryCityGeocoderService;
import kpfu.logistic.server.service.api.geocoder.google.GeoService;
import kpfu.logistic.server.service.api.geocoder.google.GeocodePojoResultParcerImpl;
import kpfu.logistic.server.service.api.geocoder.google.GeocodePojoResultParser;
import kpfu.logistic.server.service.api.geocoder.google.GoogleCountryCityGeocoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"kpfu.logistic.server.service"})
@PropertySource({"classpath:/app.properties"})
public class ServiceConfig {


    @Autowired
    private Environment env;

    @Bean
    public Crypter crypter() {
        return new Md5Crypter(this.env.getProperty("crypter.soil"));
    }

    @Autowired
    @Bean
    public CountryCityGeocoderService geoService(GeocodePojoResultParser geocodePojoResultParser) {
        return new GoogleCountryCityGeocoderService("AIzaSyBh4C18yZ5ayi3f07lJOf-I4Wjz5U9uaGc", "https://maps.googleapis.com/maps/api/geocode/", geocodePojoResultParser);
    }
}
