package com.ontopoff.collections;


public class StackClass extends java.util.Stack {

    private ListClass Stack;

    StackClass() {
        Stack = new ListClass();
    }

    public Object push(Object value) {
        Stack.add(value);
        return value;
    }

    public Object pop() {
        if (Stack.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("Невозможно выполнить операцию pop(), так как стек пуст");
        }
        Object showPop = Stack.get(Stack.size() - 1);
        Stack.remove(Stack.size() - 1);
        return showPop;
    }

    public Object peek() {
        if (Stack.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("Невозможно выполнить операцию peek(), так как стек пуст");
        }
        return Stack.get(Stack.size() - 1);
    }

    public boolean empty() {
        return Stack.size() == 0;
    }

    public int size() {
        return Stack.size();
    }
}
