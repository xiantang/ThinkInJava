package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListsTest {
    @Test
    public void testReverseLinkedList() {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");

        first.next = second;
        second.next = third;

        Node root = LinkedLists.reverse(first);
        assertEquals("3", root.data);
        assertEquals("2", root.next.data);
        assertEquals("1", root.next.next.data);
        assertNull(root.next.next.next);

    }


    @Test
    public void testLinkedListHasCycle() {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        first.next = second;
        second.next = third;
        third.next = first;
        boolean hasCycle = LinkedLists.validateCycle(first);
        assertTrue( hasCycle);
        Node first1 = new Node("1");
        first1.next = first1;
        boolean hasCycle1 = LinkedLists.validateCycle(first1);
        assertTrue(hasCycle1);

    }





}
