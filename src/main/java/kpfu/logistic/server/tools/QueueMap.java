/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.tools;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rz
 */
public interface QueueMap<K, V> {

    class Entry<K, V> {
        private K key;
        private V value;

        public Entry() {
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public Entry setKey(K key) {
            this.key = key;
            return this;
        }

        public V getValue() {
            return value;
        }

        public Entry setValue(V value) {
            this.value = value;
            return this;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Entry{");
            sb.append("key=").append(key);
            sb.append(", value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * @param removeHeadIfFull if true then head of queue will be removed if size of queue same as capacity
     * @return true - successful, false - failure
     */
    boolean offer(K key, V value, boolean removeHeadIfFull);

    void offerAll(Map<K, V> map, boolean removeHeadIfFull);

    /**
     *
     * Same as offer
     * @see this.offer
     */
    boolean put(K key, V value, boolean removeHeadIfFull);

    /**
     *
     * @return null if queue empty
     */
    Entry<K, V> poll();

    /**
     *
     * @return null if queue empty
     */
    Entry<K, V> peek();

    V get(K key);

    int size();

    int capacity();

    Set<K> keySet();

    Collection<V> values();

    Set<Entry<K, V>> entrySet();
}

