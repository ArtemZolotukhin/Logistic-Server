/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.sevice.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rtmss
 */
@Component
public class EmailValidatorImpl implements EmailValidator{

    @Override
    public boolean validate(String email) {
        return checkEmail(email);
    }
    
    private boolean checkEmail(String email) {
        if (email == null) {
            return false;
        } 

        Pattern p = Pattern.compile(".+@.+\\..+");
        Matcher m = p.matcher(email);

        return m.matches();
    }
    
}
