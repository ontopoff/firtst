package com.ontopoff.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListClass implements java.util.List {

    private int head;
    private int size;
    private int[] next;
    Object[] data;
    private int cnt;

    ListClass() {
        size = 0;
        next = new int[size+1];
        head = 0;
        cnt = 1;
        data = new Object[size+1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        int listCurr = this.head;
        for(int listId = 0; listId <= index; ++listId) {
            listCurr = next[listId];
        }
        return data[listCurr];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int head, Object v) {
        if(head == data.length) {
            size++;
            Object[] newData = new Object[size + 1];
            System.arraycopy(data, 0, newData, 1, data.length);
            data = newData;
            int[] newNext = new int[size + 1];
            System.arraycopy(next, 0, newNext, 1, next.length);
            next = newNext;
        }
        next[0] = head;
        data[0] = v;
        this.head = cnt++;
    }

    @Override
    public Object remove(int index) {
        if(this.head == 0) {
            return null;
        }
        int listCurr = this.head;
        for(int listId = 0; listId <= index; ++listId) {
            listCurr = next[listId];
            next[listId]--;
        }
        System.out.println("Удаляемое значение: " + data[listCurr]);
        Object[] newData = new Object[size];

        int iterListId = 0, listId = 0;
        while (iterListId < data.length) {
            if(iterListId != listCurr) {
                newData[listId] = data[iterListId];
                listId++;
            }
            iterListId++;
        }
        data = newData;
        int[] newNext = new int[size];

        iterListId = 0;
        listId = 0;
        while (iterListId < data.length) {
            if(iterListId != listCurr) {
                newNext[listId] = next[iterListId];
                listId++;
            }
            iterListId++;
        }
        next = newNext;
        size--;
        head = --cnt;
        for (int i = 0; i < next.length; ++i) {
            System.out.println(next[i]);
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public static void main(String[] args) {
        ListClass List = new ListClass();
        List.add(List.head, 1);
        List.add(List.head, 2);
        List.add(List.head, 3);
        List.add(List.head, 4);
        System.out.println(List.data[0]);
        System.out.println(List.data[1]);
        System.out.println(List.data[2]);
        System.out.println(List.data[3]);
        System.out.println(List.get(0));
        System.out.println(List.get(1));
        System.out.println(List.get(3));
        List.remove(1);
        List.remove(2);
        List.remove(0);
    }
}
