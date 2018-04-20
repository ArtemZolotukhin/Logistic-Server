/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder.google;

import kpfu.logistic.server.service.api.geocoder.CountryCityFormated;
import kpfu.logistic.server.service.api.geocoder.google.pojo.GeocodePojoResult;
import kpfu.logistic.server.service.api.geocoder.google.pojo.Result;
import kpfu.logistic.server.tools.CollectionsTools;
import org.springframework.stereotype.Component;

/**
 *
 * @author rz
 */
@Component
public class GeocodePojoResultParcerImpl implements GeocodePojoResultParser{

    @Override
    public CountryCityFormated parse(GeocodePojoResult geocodePojoResult) {
        
        String country = "";
        
        String city = "";
        
        for (Result i : geocodePojoResult.getResults()) {
            
            if (country.length() <= 0 && city.length() <= 0) {
            
                if (CollectionsTools.containAll(i.getTypes(), "locality", "political")) {
                    if (i.getFormattedAddress() != null) {
                    
                        String[] raw = i.getFormattedAddress().split(",");

                        if (raw != null) {
                            if (raw.length > 0) {
                                for (int k = 0; k < raw.length; k++) {
                                    if (raw[k] != null) {
                                        raw[k] = raw[k].trim();
                                    }
                                }

                                if (raw.length >= 2) {
                                    city = raw[0];
                                    country = raw[raw.length - 1];
                                }
                            }
                        }
                    }
                }
            } else {
                break;
            }
            
        }
        
        if (country.length() > 0 && city.length() > 0) {
            return new CountryCityFormated(country, city);
        } else {
            return null;
        }
        
    }
    
}
