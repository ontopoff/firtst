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
    public int size() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
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
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Object get(Object key) {
        if(key == null) {
            if(nullKey) {
                return nullKeyValue;
            } else {
                System.out.println("Элемент с key = "+ key + " не был найден!");
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
            if(!nullKey) {
                System.out.println("Элемент с key = null не был найден!");
                System.out.println("На его место будет записано значение: "+ value);
            } else {
                System.out.println("Элементу с key = null будет перезаписано значение: "+ value);
            }
            nullKey = true;
            nullKeyValue = value;
        } else {
            if (hashMap.contains(key)) {
                System.out.println("Элемент с key = "+ key +" уже записан. Его значение будет перезаписано на: "+ value);
                hashMap.put(key, value);
            } else {
                System.out.println("На его место будет записано значение: "+ value);
                hashMap.put(key, value);
                cnt++;
            }
        }
        return null;
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
}
