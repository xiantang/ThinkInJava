package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No25MergeTwoSortedLinkedListTest {

    @Test
    public void testMergeTwoSortedLinkedList() {
        Node<Integer> a1 = new Node<>(1);
        Node<Integer> a2 = new Node<>(3);
        Node<Integer> a3 = new Node<>(5);
        Node<Integer> a4 = new Node<>(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        Node<Integer> b1 = new Node<>(2);
        Node<Integer> b2 = new Node<>(4);
        Node<Integer> b3 = new Node<>(6);
        Node<Integer> b4 = new Node<>(8);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        Node<Integer> res = No25MergeTwoSortedLinkedList.merge(a1, b1);
        for (int i = 1; i <= 8; i++) {
            int data = res.data;
            assertEquals(i, data);
            res = res.next;
        }
    }


}

