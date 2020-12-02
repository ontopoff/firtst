package com.ontopoff.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;

public class ListClass implements java.util.List {

    private int head;
    private int size;
    private Object[] data;

    ListClass() {
        this.size = 0;
        head = -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == -1;
    }

    @Override
    public boolean contains(Object value) {
        if (size == 0) {
            return false;
        }
        int currentId = this.head;
        for (int listId = 0; listId < this.size; ++listId) {
            if (data[currentId] == value) {
                return true;
            } else {
                currentId++;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object value) {
        int listId = this.head;
        if (listId == -1) {
            this.head = 0;
            data = new Object[1];
            data[0] = value;
            size++;
        } else {
            data = Arrays.copyOf(data, data.length + 1);
            data[size] = value;
            size++;
        }
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Список не поддерживает отрицательные индексы");
        } else if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс искомого элемента превосходит количество элементов списка");
        } else {
            return data[index];
        }
    }

    @Override
    public void add(int index, Object value) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Список не поддерживает отрицательные индексы");
        } else if (index > size) {
            throw new ArrayIndexOutOfBoundsException("Индекс вставляемого элемента превосходит размеры списка");
        } else if (this.head == -1) {
            this.head = 0;
            data = new Object[1];
            data[0] = value;
            size++;
        } else {
            data = Arrays.copyOf(data, data.length + 1);
            for (int i = size - 1; i >= index; --i) {
                data[i + 1] = data[i];
            }
            data[index] = value;
            ++size;
        }
    }

    @Override
    public Object remove(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Список не поддерживает отрицательные индексы");
        } else if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс удаляемого элемента превосходит размеры списка");
        } else {
            if (index == 0) {
                System.out.println("Удаляемое значение: " + data[index]);
                Object retValue = data[index];
                Object[] cpyData = new Object[data.length - 1];
                System.arraycopy(data, 1, cpyData, 0, cpyData.length);
                data = new Object[cpyData.length];
                System.arraycopy(cpyData, 0, data, 0, cpyData.length);
                size--;
                if (size == 0) {
                    this.head = -1;
                }
                return retValue;
            } else {
                System.out.println("Удаляемое значение: " + data[index]);
                Object retValue = data[index];
                for (int i = index; i < size - 1; ++i) {
                    data[i] = data[i + 1];
                }
                Object[] cpyData = new Object[data.length - 1];
                System.arraycopy(data, 0, cpyData, 0, data.length - 1);
                data = new Object[cpyData.length];
                System.arraycopy(cpyData, 0, data, 0, cpyData.length);
                size--;
                return retValue;
            }

        }
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }
}
