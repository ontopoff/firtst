package com.ontopoff.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Arrays;

public class ListClass implements java.util.List {

    private int head;
    private int size;
    private int[] next;
    Object[] data;
    private int cnt;

    ListClass(int size) {
        this.size = size;
        next = new int[size+1];
        Arrays.fill(next, -1);
        head = -1;
        cnt = 0;
        data = new Object[size+1];
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
        if(cnt == 0) {
            return false;
        }
        int currentId = this.head;
        for(int listId = 0; listId < this.cnt; ++listId) {
            if(data[currentId] == value) {
                return true;
            } else {
                currentId = next[currentId];
            }
        }
        return false;
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
    public boolean add(Object value) {
        int listId = this.head;
        if(listId == -1) {
            this.head = 0;
            data[0] = value;
            cnt++;
        } else {
            while (next[listId] != -1) {
                listId = next[listId];
            }
            next[listId] = ++listId;
            data[listId] = value;
            cnt++;
        }
        return true;
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
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public Object get(int index) {
        if(index < 0) {
            throw new ArrayIndexOutOfBoundsException("Список не поддерживает отрицательные индексы");
        } else if(index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс искомого элемента превосходит количество элементов списка");
        } if(index >= cnt) {
            throw new ArrayIndexOutOfBoundsException("Элемент с таким индексом не найден");
        } else {
            int listId = this.head;
            int foundId = -1;
            if ((next[listId] == -1) || (index == 0)) {
                return data[listId];
            } else {
                for (int i = 0; i < index; ++i) {
                    foundId = next[listId];
                    listId = foundId;
                }
            }
            return data[foundId];
        }
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Этот метод не реализован!");
    }

    @Override
    public void add(int index, Object value) {
        if(index < 0) {
            throw new ArrayIndexOutOfBoundsException("Список не поддерживает отрицательные индексы");
        } else if((index > cnt) || (index >= size)) {
            throw new ArrayIndexOutOfBoundsException("Индекс вставляемого элемента превосходит размеры списка");
        } else if(this.head == -1) {
            this.head = 0;
            data[0] = value;
            cnt++;
        } else {
            int listId = this.head;
            int headId = listId;
            int beforePasteId = listId, pasteId = listId;
            int beforeId = listId, foundId;

            if (index == cnt) {
                while (next[listId] != -1) {
                    listId = next[listId];
                }
                next[listId] = ++listId;
                data[listId] = value;
                next[listId] = -1;
                cnt++;
            } else {
                while (next[listId] != -1) {
                    beforeId = listId;
                    listId = next[listId];
                }
                foundId = listId;
                ++listId;
                data[listId] = data[foundId];
                next[foundId] = -1;
                next[listId] = -1;
                next[beforeId] = listId;
                if(cnt == 1) {
                    headId = listId;
                }

                if (index == 0) {
                    this.head = foundId;
                    next[foundId] = headId;
                    data[foundId] = value;
                    cnt++;
                } else {
                    for (int i = 0; i < index; ++i) {
                        beforePasteId = pasteId;
                        pasteId = next[pasteId];
                    }
                    next[foundId] = next[beforePasteId];
                    next[beforePasteId] = foundId;
                    data[foundId] = value;
                    cnt++;
                }
            }
        }
    }

    @Override
    public Object remove(int index) {
        if(index < 0) {
            throw new ArrayIndexOutOfBoundsException("Список не поддерживает отрицательные индексы");
        } else if(index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс удаляемого элемента превосходит размеры списка");
        } if(index >= cnt) {
            throw new ArrayIndexOutOfBoundsException("Элемент с таким индексом не найден и не может быть удален");
        } else {
            int listCurr = this.head;
                if (index == 0) {
                    System.out.println("Удаляемое значение: " + data[listCurr]);
                    this.head = next[listCurr];
                    next[listCurr] = -1;
                    cnt--;
                } else {
                    int foundId = listCurr, beforeId = listCurr;
                    for (int i = 0; i < index; ++i) {
                        beforeId = foundId;
                        foundId = next[foundId];
                    }
                    System.out.println("Удаляемое значение: " + data[foundId]);
                    next[beforeId] = next[foundId];
                    next[foundId] = -1;
                    cnt--;
                }
            return data[listCurr];
        }
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
