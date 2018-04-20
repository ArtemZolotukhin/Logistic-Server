/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.tools.cache;

/**
 *
 * @author rz
 */
public class TimeCacherValueEntry<V> {
    
    private long time;
    
    private V value;

    public TimeCacherValueEntry(long time, V value) {
        this.time = time;
        this.value = value;
    }
    
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    
    
}
