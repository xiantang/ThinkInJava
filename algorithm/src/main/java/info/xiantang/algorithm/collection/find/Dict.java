package info.xiantang.algorithm.collection.find;

import info.xiantang.algorithm.collection.base.LinkList;

import java.lang.reflect.Array;

@SuppressWarnings({"unchecked"})
public class Dict<K, V> {

    private DictHt<K,V>[] dictHts = new DictHt[2];
    private int treHashIndex = -1;

    Dict(int size, double placeHolder) {
        dictHts[0] = new DictHt(size, placeHolder);
    }

    public void put(K key, V value) {
        boolean isHashing = progressiveRehash();
        if (isHashing) {
            dictHts[1].put(key, value);
        } else {
            dictHts[0].put(key, value);
        }
    }

    public V get(K key) {
        boolean isHashing = progressiveRehash();
        if (isHashing) {
            V value = dictHts[0].get(key);
            if (value == null) {
                return dictHts[1].get(key);
            }
            return value;
        } else {
            return dictHts[0].get(key);
        }
    }

    private void replaceEntry(DictHt dictHt0) {
        DictHt dictHt1 = dictHts[1];
        treHashIndex += 1;
        DictHt.Entry<K, V> entry = dictHt0.entries[treHashIndex];
        LinkList<DictHt.Node<K, V>> linkList = entry.linkList;
        for (DictHt.Node<K, V> next : (Iterable<DictHt.Node<K, V>>) linkList) {
            dictHt1.put(next.key, next.value);
        }
        dictHt0.entries[treHashIndex] = new DictHt.Entry();
    }

    private boolean progressiveRehash() {
        DictHt dictHt0 = dictHts[0];
        DictHt dictHt1 = dictHts[1];
        if (dictHt0.placeHolder <= dictHt0.getLoadFactor() && dictHt1 == null) {
            dictHts[1] = new DictHt(dictHt0.size * 2, DictHt.DEFAULT_PLACE_HOLDER);
            replaceEntry(dictHt0);
            return true;
        } else if (treHashIndex != -1 && treHashIndex != dictHt0.size - 1) {
            replaceEntry(dictHt0);
            return true;
        } else if (treHashIndex == dictHt0.size - 1) {
            treHashIndex = -1;
            dictHts[0] = dictHts[1];
            dictHts[1] = null;
            return false;
        }
        return false;
    }

    public int getSize() {
        if (dictHts[1] != null) {
            return dictHts[1].size;
        } else return dictHts[0].size;
    }

    int getTreHashIndex() {
        return treHashIndex;
    }


    protected static class DictHt<K, V> {

        private final double placeHolder;
        private Entry<K, V>[] entries;
        private static final double DEFAULT_PLACE_HOLDER = 0.75;
        private static final int DEFAULT_SIZE = 8;
        private int size;
        private int sizeMask;
        private int used = 0;

        double getLoadFactor() {
            return used / 1.0 / size;
        }

        DictHt() {
            this(DEFAULT_SIZE, DEFAULT_PLACE_HOLDER);
        }

        DictHt(int size, double placeHolder) {
            this.size = size;
            this.entries = (Entry<K, V>[]) Array.newInstance(Entry.class, size);
            this.sizeMask = size - 1;
            this.placeHolder = placeHolder;
            for (int i = 0; i < entries.length; i++) {
                entries[i] = new Entry<>();
            }
        }

        public void put(K key, V value) {
            Entry entry = getKeyEntry(key);
            Node<K, V> node = getNode(key, entry);
            if (node != null) {
                node.value = value;
            } else {
                Node<K, V> newNode = new Node<>(key, value);
                entry.insert(newNode);
                used += 1;
            }
        }

        private Entry<K, V> getKeyEntry(K key) {
            int hashCode = key.hashCode();
            int index = hashCode & sizeMask;
            return entries[index];
        }

        private Node<K, V> getNode(K key) {
            Entry entry = getKeyEntry(key);
            return getNode(key, entry);
        }

        private Node<K, V> getNode(K key, Entry entry) {
            LinkList<Node<K, V>> linkList = entry.getLinkList();
            for (Node<K, V> next : (Iterable<Node<K, V>>) linkList) {
                if (next.key.equals(key)) {
                    return next;
                }
            }
            return null;
        }

        public V get(K key) {
            Node<K, V> node;
            if ((node = getNode(key)) != null) {
                return node.value;
            }
            return null;
        }

        int getUseSize() {
            return used;
        }


        private static class Node<K, V> {
            private K key;
            private V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private static class Entry<K, V> {
            private LinkList<Node<K, V>> linkList = new LinkList<>();

            public void insert(Node<K, V> node) {
                linkList.add(node);
            }

            LinkList<Node<K, V>> getLinkList() {
                return linkList;
            }
        }
    }
}