/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder;

import java.io.IOException;

/**
 *
 * @author rz
 */
public interface CountryCityGeocoderService {
    
    CountryCityFormated geocode(CountryCityRaw countryCityRaw) throws IOException, UnknownCountryCityException;
    
    CountryCityFormated geocode(LatitudeLongitude latitudeLongitude) throws IOException, UnknownCountryCityException;
    
}
