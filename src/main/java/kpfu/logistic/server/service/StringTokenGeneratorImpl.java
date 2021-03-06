/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 *
 * @author rtmss
 */
@Service
public class StringTokenGeneratorImpl implements StringTokenGenerator {

    @Autowired
    private Crypter crypter;
    
    @Override
    public String generate() {
        return crypter.crypt(Long.toString(System.currentTimeMillis()) 
                + Integer.toString(new Random(System.currentTimeMillis()).nextInt()));
    }
    
}
