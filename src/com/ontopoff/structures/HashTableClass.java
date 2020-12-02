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
        if (node != null) {
            V copyValue = node.value;
            node.value = value;
            return copyValue;
        }
        node = new LinkedListItem<K, V>(key, value);
        int index = getIndex(key);
        if (hashTable.get(index) != null) {
            node.next = hashTable.get(index);
            node.next.prev = node;
        }
        hashTable.set(index, node);
        return null;
    }

    public V remove(K key) {
        LinkedListItem<K, V> node = getNode(key);
        if (node == null) {
            throw new NullPointerException("Элемент с таким ключом не был найден и не может быть удален");
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int hash = getIndex(key);
            hashTable.set(hash, node.next);
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node.value;
    }

    public boolean contains(K key) {
        if (key == null) {
            throw new NullPointerException("Ключ не поддерживает значение null");
        }
        LinkedListItem<K, V> node = getNode(key);
        return node == null ? false : true;
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("Ключ не поддерживает значение null");
        }
        LinkedListItem<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    private LinkedListItem<K, V> getNode(K key) {
        int index = getIndex(key);
        LinkedListItem<K, V> currItem = hashTable.get(index);
        while (currItem != null) {
            if (currItem.key.equals(key)) {
                return currItem;
            }
            currItem = currItem.next;
        }
        return null;
    }

    public int getIndex(K key) {
        return Math.abs(key.hashCode() % hashTable.size());
    }
}
