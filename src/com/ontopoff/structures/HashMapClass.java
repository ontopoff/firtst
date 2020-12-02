package com.ontopoff.structures;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMapClass implements java.util.Map {

    private HashTableClass hashMap;
    private int cnt;
    private boolean nullKey;
    private Object nullKeyValue;

    HashMapClass(int size) {
        hashMap = new HashTableClass(size);
        cnt = 0;
        nullKey = false;
        nullKeyValue = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.cnt == 0) ? true : false;
    }

    @Override
    public boolean containsKey(Object key) {
        if(key == null) {
            if(nullKey) {
                return true;
            } else {
                return false;
            }
        } else {
            if (hashMap.contains(key)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Object get(Object key) {
        if(key == null) {
            if(nullKey) {
                return nullKeyValue;
            } else {
                return null;
            }
        } else {
            if(hashMap.contains(key)) {
                return hashMap.get(key);
            } else {
                return null;
            }
        }
    }

    @Override
    public Object put(Object key, Object value) {
        if(key == null) {
            nullKey = true;
            nullKeyValue = value;
        } else {
            if (hashMap.contains(key)) {
                hashMap.put(key, value);
            } else {
                hashMap.put(key, value);
                cnt++;
            }
        }
        return null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Set<Entry> entrySet() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }
}
