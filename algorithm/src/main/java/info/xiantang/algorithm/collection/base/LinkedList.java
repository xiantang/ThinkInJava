package info.xiantang.algorithm.collection.base;

import java.util.Iterator;

/**
 * Left 1 -> 2 -> 3 ->4  Right
 * @param <Item>
 */
public class LinkedList<Item> implements Iterable{


    public int size() {
        return N;
    }

    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private int N;

    /**
     * 使用头插法插入元素
     * @param item
     */
    public void linsert(Item item){
        Node oldfirst = first;
        N++;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }


    public void rinsert(Item item) {
        Node tail = new Node();
        tail.item = item;
        tail.next = null;
        if (first == null) {
            first = tail;
        } else {
            Node cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = tail;
        }
        N++;

    }

    Item head() {
        return first.item;
    }

    public Item lremove() {
        if (first == null) {
            throw new IndexOutOfBoundsException("list not have element");
        }
        Node preFirst = first;
        Item item = preFirst.item;
        first = first.next;
        preFirst.next = null;
        N--;
        return item;
    }


    public void delLast(){
        Node prelast = first ;
        Node last = first.next;
        if (last == null){
            first = null;
        }else {
            while (last.next!=null){
                prelast = prelast.next;
                last = last.next;
            }
            prelast.next = null;

        }

    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current !=null;
        }
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
