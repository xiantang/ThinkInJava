package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No23FindLinkedListEntranceTest {

    @Test
    public void testFindLinkedListEntrance() {

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
        a6.next = a3;
        Node<Integer> node = No23FindLinkedListEntrance.find(a1);
        assertEquals(a3, node);
    }

}
