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
public class UnknownCountryCityException extends Exception{

    public UnknownCountryCityException() {
    }

    public UnknownCountryCityException(String message) {
        super(message);
    }

    public UnknownCountryCityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownCountryCityException(Throwable cause) {
        super(cause);
    }
    
}
