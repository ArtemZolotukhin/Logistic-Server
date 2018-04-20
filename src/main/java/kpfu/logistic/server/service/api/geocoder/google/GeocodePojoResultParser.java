/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder.google;

import kpfu.logistic.server.service.api.geocoder.CountryCityFormated;
import kpfu.logistic.server.service.api.geocoder.google.pojo.GeocodePojoResult;

/**
 *
 * @author rz
 */
public interface GeocodePojoResultParser {
    
    CountryCityFormated parse(GeocodePojoResult geocodePojoResult);
    
}
