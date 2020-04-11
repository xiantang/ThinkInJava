package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class No22LastKNodeInLinkedListTest {

    @Test
    public void testLastKNodeInLinkedList() {
        Node<Integer> a1 = new Node<>(1);
        Node<Integer> a2 = new Node<>(2);
        Node<Integer> a3 = new Node<>(3);
        Node<Integer> a4 = new Node<>(4);
        Node<Integer> a5 = new Node<>(5);
        Node<Integer> a6 = new Node<>(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        Node<Integer> node = LastKNodeInLinkedList.find(a1, 3);
        assertEquals(a4, node);
    }

    @Test
    public void testRootWasNull() {

        Node<Integer> a1 = null;
        Node<Integer> node = LastKNodeInLinkedList.find(a1, 3);
        assertNull(node);


    }
}