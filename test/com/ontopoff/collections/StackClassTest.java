package com.ontopoff.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackClassTest {

    @Test
    @DisplayName("empty method test without elements")
    void testEmptyStackTrue() {
        StackClass Stack = new StackClass(1);
        Assertions.assertEquals(true, Stack.empty());
    }

    @Test
    @DisplayName("empty method test with element")
    void testEmptyStackFalse() {
        StackClass Stack = new StackClass(1);
        Stack.push(0);
        Assertions.assertEquals(false, Stack.empty());
    }

    @Test
    @DisplayName("push method test")
    void testPush() {
        StackClass Stack = new StackClass(2);
        Stack.push(0);
        Stack.push(1);
        Assertions.assertEquals(1, Stack.peek());
        Stack.pop();
        Assertions.assertEquals(0, Stack.peek());
    }

    @Test
    @DisplayName("push method test stack overflow")
    void throwsExceptionPushOverflow() {
        StackClass Stack = new StackClass(1);
        Stack.push(0);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> Stack.push(1));
    }

    @Test
    @DisplayName("pop method test")
    void testPop() {
        StackClass Stack = new StackClass(2);
        Stack.push(0);
        Stack.push(1);
        Assertions.assertEquals(1, Stack.pop());
        Assertions.assertEquals(0, Stack.pop());
    }

    @Test
    @DisplayName("push method test empty stack")
    void throwsExceptionPopEmptyStack() {
        StackClass Stack = new StackClass(1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> Stack.pop());
    }

    @Test
    @DisplayName("peek method test")
    void testPeek() {
        StackClass Stack = new StackClass(2);
        Stack.push(0);
        Stack.push(1);
        Assertions.assertEquals(1, Stack.peek());
        Assertions.assertEquals(2, Stack.size());
    }

    @Test
    @DisplayName("peek method test empty stack")
    void throwsExceptionPeekEmptyStack() {
        StackClass Stack = new StackClass(1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class , () -> Stack.peek());
    }

    @Test
    @DisplayName("count elements test")
    void testSize() {
        StackClass Stack = new StackClass(2);
        Stack.push(0);
        Assertions.assertEquals(1, Stack.size());
    }

}