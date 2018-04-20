/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder.google;

import kpfu.logistic.server.service.api.geocoder.google.pojo.GeocodePojoResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * @author rz
 */
public interface GeoService {
    
    @GET("json")
    Call<GeocodePojoResult> byCountryCity(@Query("address") String countryCity, @Query("key") String apiKey);
    
    @GET("json")
    Call<GeocodePojoResult> byLatLng(@Query("latlng") String latLngDeviderComme, @Query("key") String apiKey);
    
}
