package info.xiantang.algorithm.collection.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {


    @Test
    public void testHeadAdd() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.linsert(1);
        int head1 = linkedList.head();
        assertEquals(head1, 1);
        linkedList.linsert(2);
        int head2 = linkedList.head();
        assertEquals(head2, 2);
        linkedList.linsert(3);
        int head3 = linkedList.head();
        assertEquals(head3, 3);
    }


    @Test
    public void testTailAdd() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.rinsert(1);
        linkedList.rinsert(2);
        linkedList.linsert(3);
        Iterator<Integer> iterator = linkedList.iterator();
        List<Integer> expect = new ArrayList<>();
        expect.add(3);
        expect.add(1);
        expect.add(2);
        List<Integer> actual = new ArrayList<>();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            actual.add(next);
        }
        assertEquals(expect, actual);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testLRemove() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.rinsert(1);
        linkedList.rinsert(2);
        linkedList.rinsert(3);
        int first = linkedList.lremove();
        assertEquals(1, first);
        int second = linkedList.lremove();
        assertEquals(2, second);
        assertEquals(Integer.valueOf(3), linkedList.head());
        int third = linkedList.lremove();
        assertEquals(3, third);
        linkedList.lremove();
    }
}
