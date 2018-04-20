/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.tools;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author rz
 */
public class LinkedBlockingQueueHashMap<K, V> implements QueueMap<K, V> {


    private LinkedBlockingQueue<K> linkedBlockingQueue;
    private HashMap<K, V> hashMap;
    private int capacity;

    public LinkedBlockingQueueHashMap(int capacity) {
        this.capacity = capacity;
        linkedBlockingQueue = new LinkedBlockingQueue<K>(capacity);
        hashMap = new HashMap<K, V>();
    }

    @Override
    public synchronized boolean offer(K key, V value, boolean removeHeadIfFull) {
        if (linkedBlockingQueue.size() == capacity) {
            if (removeHeadIfFull) {
                if (hashMap.get(key) == null) {
                    K k = linkedBlockingQueue.poll();
                    hashMap.remove(k);
                    linkedBlockingQueue.offer(key);
                }
                hashMap.put(key, value);
                return true;
            } else {
                return false;
            }
        } else {
            if (hashMap.get(key) == null) {
                linkedBlockingQueue.offer(key);
            }
            hashMap.put(key, value);
            return true;
        }

    }

    @Override
    public void offerAll(Map<K, V> map, boolean removeHeadIfFull) {
        if (map == null) {
            return;
        }
        Set<Map.Entry<K, V>> set = map.entrySet();
        for (Map.Entry<K, V> i : set) {
            if (i != null) {
                offer(i.getKey(), i.getValue(), removeHeadIfFull);
            }
        }
    }

    @Override
    public synchronized boolean put(K key, V value, boolean removeHeadIfFull) {
        return offer(key, value, removeHeadIfFull);
    }


    @Override
    public synchronized Entry<K, V> poll() {

        K k = linkedBlockingQueue.poll();
        if (k != null) {
            V v = hashMap.get(k);
            hashMap.remove(k);
            return new Entry<K, V>(k, v);
        }

        return null;
    }

    @Override
    public Entry<K, V> peek() {
        K k = linkedBlockingQueue.peek();
        if (k != null) {
            V v = hashMap.get(k);
            return new Entry<K, V>(k, v);
        }
        return null;
    }

    @Override
    public V get(K key) {
        return hashMap.get(key);
    }

    @Override
    public int size() {
        return linkedBlockingQueue.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public Set<K> keySet() {
        return hashMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return hashMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> set = new HashSet<>();
        for (Map.Entry<K, V> i : hashMap.entrySet()) {
            set.add(new Entry<K, V>(i.getKey(), i.getValue()));
        }
        return set;
    }
}

