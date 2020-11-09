package com.ontopoff.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HashMapClassTest {

    @Test
    @DisplayName("isEmpty method test")
    void testIsEmpty() {
        HashMapClass hashMap = new HashMapClass(5);
        Assertions.assertEquals(true, hashMap.isEmpty());
        hashMap.put(0,1);
        hashMap.put(0,2);
        Assertions.assertEquals(false, hashMap.isEmpty());
    }

    @Test
    @DisplayName("containsKey method test")
    void testContainsKey() {
        HashMapClass hashMap = new HashMapClass(5);
        hashMap.put(null,1);
        hashMap.put(0,null);
        Assertions.assertEquals(true, hashMap.containsKey(null));
        Assertions.assertEquals(true, hashMap.containsKey(0));
        Assertions.assertEquals(false, hashMap.containsKey(1));
    }

    @Test
    @DisplayName("get method test")
    void testGet() {
        HashMapClass hashMap = new HashMapClass(5);
        hashMap.put(null,1);
        hashMap.put(0,null);
        Assertions.assertEquals(1, hashMap.get(null));
        Assertions.assertEquals(null, hashMap.get(0));
        Assertions.assertEquals(null, hashMap.get(1));
    }

    @Test
    @DisplayName("put method test")
    void testPut() {
        HashMapClass hashMap = new HashMapClass(5);
        hashMap.put(null,1);
        hashMap.put(0,"hello");
        Assertions.assertEquals(1, hashMap.get(null));
        Assertions.assertEquals("hello", hashMap.get(0));
        hashMap.put(0,"goodbye");
        Assertions.assertEquals("goodbye", hashMap.get(0));
    }

}