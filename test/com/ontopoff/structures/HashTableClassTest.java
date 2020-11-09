package com.ontopoff.structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HashTableClassTest {

    @Test
    @DisplayName("put method test")
    void testPut() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(4,10);
        Assertions.assertEquals(0, hashTable.get(0));
        Assertions.assertEquals(10, hashTable.get(4));
        hashTable.put(4,5);
        Assertions.assertEquals(5, hashTable.get(4));
        hashTable.put(9,10);
        Assertions.assertEquals(10, hashTable.get(9));
        Assertions.assertEquals(5, hashTable.get(4));
    }

    @Test
    @DisplayName("remove method test")
    void testRemove() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        hashTable.put(2,4);
        hashTable.put(3,6);
        hashTable.put(4,8);
        hashTable.put(9,10);
        Assertions.assertEquals(0, hashTable.remove(0));
        Assertions.assertEquals(4, hashTable.remove(2));
        Assertions.assertEquals(8, hashTable.remove(4));
        Assertions.assertEquals(10, hashTable.remove(9));
    }

    @Test
    @DisplayName("remove method test: Attempt to delete a nonexistent item")
    void throwsExceptionRemoveNullPointer() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        hashTable.put(3,4);
        hashTable.put(4,6);
        Assertions.assertThrows(NullPointerException.class , () -> hashTable.remove(2));
    }

    @Test
    @DisplayName("get method test found element")
    void testGetFoundItem() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        hashTable.put(6,4);
        Assertions.assertEquals(2, hashTable.get(1));
        Assertions.assertEquals(4, hashTable.get(6));
    }

    @Test
    @DisplayName("get method test not found element")
    void testGetNotFoundItem() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        hashTable.put(6,4);
        Assertions.assertEquals(null, hashTable.get(2));
    }

    @Test
    @DisplayName("get method test: Null key")
    void throwsExceptionGetNullKey() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        Assertions.assertThrows(NullPointerException.class , () -> hashTable.get(null));
    }

    @Test
    @DisplayName("getIndex method test")
    void testGetIndex() {
        HashTableClass hashTable = new HashTableClass(5);
        Assertions.assertEquals(2, hashTable.getIndex(2));
        hashTable.put(2,0);
        Assertions.assertEquals(2, hashTable.getIndex(-2));
        hashTable.put(-2,1);
        Assertions.assertEquals(2, hashTable.getIndex(7));
        hashTable.put(7,2);
        Assertions.assertEquals(0, hashTable.get(2));
        Assertions.assertEquals(1, hashTable.get(-2));
        Assertions.assertEquals(2, hashTable.get(7));
    }

    @Test
    @DisplayName("contains method test found element")
    void testContainsFoundItem() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        Assertions.assertEquals(true, hashTable.contains(1));
    }

    @Test
    @DisplayName("contains method test not found element")
    void testContainsNotFoundItem() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        Assertions.assertEquals(false, hashTable.contains(2));
    }

    @Test
    @DisplayName("contains method test: Null key")
    void throwsExceptionContainsNullKey() {
        HashTableClass hashTable = new HashTableClass(5);
        hashTable.put(0,0);
        hashTable.put(1,2);
        Assertions.assertThrows(NullPointerException.class , () -> hashTable.contains(null));
    }

}