package com.ontopoff.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListClassTest {


    @Test
    @DisplayName("isEmpty method test without elements")
    void testIsEmptyListTrue() {
        ListClass List = new ListClass(1);
        Assertions.assertEquals(true, List.isEmpty());
    }

    @Test
    @DisplayName("isEmpty method test with element")
    void testIsEmptyListFalse() {
        ListClass List = new ListClass(1);
        List.add(0);
        Assertions.assertEquals(false, List.isEmpty());
    }

    @Test
    @DisplayName("contains method test with positive verdict")
    void testContainsTrue() {
        ListClass List = new ListClass(2);
        List.add(0);
        List.add(1);
        Assertions.assertEquals(true, List.contains(1));
    }

    @Test
    @DisplayName("contains method test with negative verdict")
    void testContainsFalse() {
        ListClass List = new ListClass(1);
        List.add(0);
        Assertions.assertEquals(false, List.contains(1));
    }

    @Test
    @DisplayName("add to the end method test")
    void testAddToTheEndOfTheList() {
        ListClass List = new ListClass(2);
        for(int itemId = 0; itemId < 2; ++itemId) {
            List.add(itemId);
            Assertions.assertEquals(itemId, List.get(itemId));
        }
    }

    @Test
    @DisplayName("get by index test")
    void testGetByIndex() {
        ListClass List = new ListClass(2);
        List.add(0);
        List.add(1);
        Assertions.assertEquals(0, List.get(0));
        Assertions.assertEquals(1, List.get(1));
    }

    @Test
    @DisplayName("get by index test not found such element")
    void throwsExceptionGetByIndexNotFoundSuchElement() {
        ListClass List = new ListClass(1);
        List.add(0);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.get(1));
    }

    @Test
    @DisplayName("get by index test negative index")
    void throwsExceptionGetByNegativeIndex() {
        ListClass List = new ListClass(1);
        List.add(0);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.get(-1));
    }

    @Test
    @DisplayName("get by index higher then list size test")
    void throwsExceptionGetByIndexHigherThenSize() {
        ListClass List = new ListClass(1);
        List.add(0);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.get(2));
    }

    @Test
    @DisplayName("add to head test")
    void testAddToHead() {
        ListClass List = new ListClass(2);
        List.add(0,0);
        List.add(0,1);
        Assertions.assertEquals(1, List.get(0));
    }

    @Test
    @DisplayName("add to any position test")
    void testAddToAnyPosition() {
        ListClass List = new ListClass(4);
        List.add(0,0);
        List.add(1,1);
        List.add(2,2);
        List.add(1,3);
        Assertions.assertEquals(3, List.get(1));
    }

    @Test
    @DisplayName("add to any position(end) test")
    void testAddToAnyPositionEnd() {
        ListClass List = new ListClass(4);
        List.add(0,0);
        List.add(1,0);
        List.add(2,0);
        List.add(3,3);
        Assertions.assertEquals(3, List.get(3));
    }

    @Test
    @DisplayName("add to any position test negative index")
    void throwsExceptionAddToAnyPositionNegativeIndex() {
        ListClass List = new ListClass(1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.add(-1,1));
    }

    @Test
    @DisplayName("add to any position higher then list size test")
    void throwsExceptionAddToAnyPositionHigherThenSize() {
        ListClass List = new ListClass(1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.add(2,1));
    }

    @Test
    @DisplayName("remove by head of list test")
    void testRemoveByIndexFromHead() {
        ListClass List = new ListClass(2);
        List.add(0);
        List.add(1);
        Assertions.assertEquals(0, List.remove(0));
        Assertions.assertEquals(1, List.get(0));
    }

    @Test
    @DisplayName("remove from any position test")
    void testRemoveByIndexFromAnyPosition() {
        ListClass List = new ListClass(3);
        List.add(0);
        List.add(1);
        List.add(2);
        Assertions.assertEquals(1, List.remove(1));
        Assertions.assertEquals(2, List.get(1));
    }

    @Test
    @DisplayName("remove element with negative index test")
    void throwsExceptionRemoveByNegativeIndex() {
        ListClass List = new ListClass(1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.remove(-1));
    }

    @Test
    @DisplayName("remove element with index higher then list size test")
    void throwsExceptionRemoveByIndexHigherThanListSize() {
        ListClass List = new ListClass(1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.remove(2));
    }

    @Test
    @DisplayName("remove element test not found element")
    void throwsExceptionRemoveByIndexNotFoundElement() {
        ListClass List = new ListClass(2);
        List.add(0);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.remove(1));
        List.remove(0);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> List.remove(0));
    }

}