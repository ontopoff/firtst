package com.ontopoff.structures;

import java.util.ArrayList;

public class HashTableClass<K, V> {

    private ArrayList<LinkedListItem<K, V>> hashTable;

    private class LinkedListItem<K, V> {
        public LinkedListItem<K, V> next;
        public LinkedListItem<K, V> prev;
        public K key;
        public V value;
        LinkedListItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    HashTableClass(int size) {
        hashTable = new ArrayList<LinkedListItem<K, V>>();
        hashTable.ensureCapacity(size);
        for (int i = 0; i < size; i++) {
            hashTable.add(null);
        }
    }

    public V put(K key, V value) {
        LinkedListItem<K, V> node = getNode(key);
        try {
            if(!node.equals(null)) {
                V copyValue = node.value;
                node.value = value;
                return copyValue;
            }
        } catch (NullPointerException e) {}
        node = new LinkedListItem<K, V>(key, value);
        int index = getIndex(key);
        try {
            if(!hashTable.get(index).equals(null)) {
                node.next = hashTable.get(index);
                node.next.prev = node;
            }
        } catch (NullPointerException e) {}
        hashTable.set(index, node);
        return null;
    }

    public V remove(K key) {
        LinkedListItem<K, V> node = getNode(key);
        try {
            if(node.equals(null)) {
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Элемент с таким ключом не был найден и не может быть удален");
        }
        try {
            if(!node.prev.equals(null)) {
                node.prev.next = node.next;
            }
        } catch (NullPointerException e) {
            int hash = getIndex(key);
            hashTable.set(hash, node.next);
        }
        try {
            if (!node.next.equals(null)) {
                node.next.prev = node.prev;
            }
        } catch (NullPointerException e) {}
        return node.value;
    }

    public boolean contains(K key) {
        try {
            if(key.equals(null)) {}
        } catch (NullPointerException e) {
            throw new NullPointerException("Ключ не поддерживает значение null");
        }
        LinkedListItem<K, V> node = getNode(key);
        try {
            if(node.equals(null)) {} else {
                return true;
            }
        } catch (NullPointerException e) {
            System.out.println("Элемент с key = "+ key + " не был найден!");
        }
        return false;
    }

    public V get(K key) {
        try {
            if(key.equals(null)) {}
        } catch (NullPointerException e) {
            throw new NullPointerException("Ключ не поддерживает значение null");
        }
        LinkedListItem<K, V> node = getNode(key);
        try {
            if(node.equals(null)) {} else {
                return node.value;
            }
        } catch (NullPointerException e) {
            System.out.println("Элемент с key = "+ key + " не был найден!");
        }
        return null;
    }

    private LinkedListItem<K, V> getNode(K key) {
        int index = getIndex(key);
        LinkedListItem<K, V> currItem = hashTable.get(index);
        try {
            while (!currItem.equals(null)) {
                if(currItem.key.equals(key)) {
                    return currItem;
                }
                currItem = currItem.next;
            }
        } catch (NullPointerException e) {}
        return null;
    }

    public int getIndex(K key) {
        return Math.abs(key.hashCode() % hashTable.size());
    }
}
