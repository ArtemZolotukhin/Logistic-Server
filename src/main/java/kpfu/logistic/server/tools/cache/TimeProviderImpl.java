/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.tools.cache;

import org.springframework.stereotype.Component;

/**
 *
 * @author rz
 */
@Component
public class TimeProviderImpl implements TimeProvider{

    @Override
    public long getTimeMillis() {
        return System.currentTimeMillis();
    }
    
}
