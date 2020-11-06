package com.ontopoff.collections;


public class StackClass extends java.util.Stack {

    private int cnt;
    private int size;
    private ListClass Stack;

    StackClass(int size) {
        this.size = size;
        cnt = 0;
        Stack = new ListClass(size);
    }

    public Object push(Object value) {
        if(cnt + 1 > size) {
            throw new ArrayIndexOutOfBoundsException("Стек переполнен");
        }
        Stack.add(value);
        cnt++;
        return value;
    }
    public Object pop() {
        if(cnt == 0) {
            throw new ArrayIndexOutOfBoundsException("Невозможно выполнить операцию pop(), так как стек пуст");
        }
        Object showPop;
        showPop = Stack.get(cnt-1);
        Stack.remove(cnt-1);
        cnt--;
        return showPop;
    }

    public Object peek() {
        if(cnt == 0) {
            throw new ArrayIndexOutOfBoundsException("Невозможно выполнить операцию peek(), так как стек пуст");
        }
        return Stack.get(cnt-1);
    }

    public boolean empty() {
        return cnt == 0;
    }

    public int size() {
        return this.cnt;
    }
}
