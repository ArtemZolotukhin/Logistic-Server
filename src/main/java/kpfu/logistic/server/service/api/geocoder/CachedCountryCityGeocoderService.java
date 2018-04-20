/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder;

import kpfu.logistic.server.tools.LinkedBlockingQueueHashMap;
import kpfu.logistic.server.tools.QueueMap;

import java.io.IOException;

/**
 *
 * @author rz
 */
public class CachedCountryCityGeocoderService implements CountryCityGeocoderService{
    
    private CountryCityGeocoderService countryCityGeocoder;
    
    private int cacheCapacity;
    
    private QueueMap<CountryCityRaw, CountryCityFormated> cache;

    public CachedCountryCityGeocoderService(CountryCityGeocoderService countryCityGeocoder, int cacheCapacity) {
        this.countryCityGeocoder = countryCityGeocoder;
        this.cacheCapacity = cacheCapacity;
        cache = new LinkedBlockingQueueHashMap<>(cacheCapacity);
    }
    
    

    @Override
    public CountryCityFormated geocode(CountryCityRaw countryCityRaw) throws IOException, UnknownCountryCityException {
        CountryCityFormated countryCityFormated = cache.get(countryCityRaw);
        if (countryCityFormated != null) {
            return countryCityFormated;
        } else {
            countryCityFormated = countryCityGeocoder.geocode(countryCityRaw);
            cache.offer(countryCityRaw, countryCityFormated, true);
            return countryCityFormated;
        }
    }

    @Override
    public CountryCityFormated geocode(LatitudeLongitude latitudeLongitude) throws IOException, UnknownCountryCityException {
        return countryCityGeocoder.geocode(latitudeLongitude);
    }

    public CountryCityGeocoderService getCountryCityGeocoder() {
        return countryCityGeocoder;
    }

    public void setCountryCityGeocoder(CountryCityGeocoderService countryCityGeocoder) {
        this.countryCityGeocoder = countryCityGeocoder;
    }

    public int getCacheCapacity() {
        return cacheCapacity;
    }    
    
}
