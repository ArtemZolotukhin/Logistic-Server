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
public interface Cacher<K, V> {
    
    V get(K k);
    
    void put(K k, V v);
    
}
