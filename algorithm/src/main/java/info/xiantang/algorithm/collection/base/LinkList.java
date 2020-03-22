package info.xiantang.algorithm.collection.base;

import java.util.Iterator;

public class LinkList<Item> implements Iterable{


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
    public void add(Item item){
        Node oldfirst = first;
        N++;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item head() {
        return first.item;
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
    }

}
