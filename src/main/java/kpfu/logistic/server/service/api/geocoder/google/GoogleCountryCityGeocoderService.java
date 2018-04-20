/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.geocoder.google;

import kpfu.logistic.server.service.api.geocoder.*;
import kpfu.logistic.server.service.api.geocoder.google.pojo.GeocodePojoResult;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Locale;

/**
 *
 * @author rz
 */

public class GoogleCountryCityGeocoderService implements CountryCityGeocoderService {

    private Retrofit retrofit;
    
    private String apiKey;
    
    private GeoService geoService;
    
    private GeocodePojoResultParser geocodePojoResultParser;
    
    public GoogleCountryCityGeocoderService(String apiKey, String baseUrl, 
            GeocodePojoResultParser geocodePojoResultParser) {
        retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        this.apiKey = apiKey;
        this.geocodePojoResultParser = geocodePojoResultParser;
        geoService = retrofit.create(GeoService.class);
    }

    
    
    @Override
    public CountryCityFormated geocode(CountryCityRaw countryCityRaw) throws IOException, UnknownCountryCityException {
        
        if (countryCityRaw == null) {
            throw new UnknownCountryCityException("CountryCityRaw is null");
        }
        
        if (countryCityRaw.getCity() == null || countryCityRaw.getCountry() == null) {
            throw new UnknownCountryCityException("CountryCityRaw one of field is missing");
        }
        
        Response<GeocodePojoResult> geocodePojoResultResponse = geoService
                .byCountryCity(countryCityRaw.getCountry() + "," + countryCityRaw.getCity(), apiKey)
                .execute();
        
        return handleResponse(geocodePojoResultResponse);
        
    }

    @Override
    public CountryCityFormated geocode(LatitudeLongitude latitudeLongitude) throws IOException, UnknownCountryCityException{
        
        if (latitudeLongitude == null) {
            throw new UnknownCountryCityException("LatLng is missing");
        }
        
        
        
        Response<GeocodePojoResult> geocodePojoResultResponse = geoService
                .byLatLng(String.format(Locale.US, "%f", latitudeLongitude.getLatitude()) + 
                        "," + String.format(Locale.US, "%f", latitudeLongitude.getLongitude()), apiKey)
                .execute();
        
        return handleResponse(geocodePojoResultResponse);
    }
    

    private CountryCityFormated handleResponse(Response<GeocodePojoResult> geocodePojoResultResponse) throws IOException, UnknownCountryCityException{
        
        if (geocodePojoResultResponse.isSuccessful()) {
            if (geocodePojoResultResponse.code() < 400) {
                GeocodePojoResult pojoResult = geocodePojoResultResponse.body();
                
                CountryCityFormated countryCityFormated = geocodePojoResultParser.parse(pojoResult);
                
                if (countryCityFormated != null) {
                    return countryCityFormated;
                } else {
                    throw new UnknownCountryCityException();
                }
                
            } else {
                throw new IOException(geocodePojoResultResponse.errorBody() + "");
            }
        } else {
            throw new IOException(geocodePojoResultResponse.errorBody() + "");
        }
        
    }
    
}
