/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.tools.cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rz
 */
public class TimeCacher<K, V> implements Cacher<K, V>{

    
    private TimeProvider timeProvider;
    
    private long liveTime;
    
    private Map<K, TimeCacherValueEntry<V>> cache;

    public TimeCacher(TimeProvider timeProvider, long liveTime) {
        
        cache = new HashMap<>();
        
        this.timeProvider = timeProvider;
        
        if (timeProvider == null) {
            throw new IllegalArgumentException("Time Provider must be not null!");
        }
        
        this.liveTime = liveTime;
        
        if (liveTime < 0) {
            throw new IllegalArgumentException("liveTime must be not negative!");
        }
    }
    
    
    
    @Override
    public V get(K k) {
        TimeCacherValueEntry<V> tv = cache.get(k);
        if (tv != null) {
            if (tv.getTime() + liveTime <= timeProvider.getTimeMillis()) {
                return tv.getValue();
            }
        } 
        return null;
        
    }

    @Override
    public void put(K k, V v) {
        TimeCacherValueEntry<V> tv = new TimeCacherValueEntry<>(timeProvider.getTimeMillis(), v);
        cache.put(k, tv);
    }
    
}
