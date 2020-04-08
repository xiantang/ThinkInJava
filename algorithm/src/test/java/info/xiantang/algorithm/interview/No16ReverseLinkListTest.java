package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class No16ReverseLinkListTest {

    @Test
    public void test() {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");

        first.next = second;
        second.next = third;

        Node root = No16ReverseLinkList.reverse(first);
        assertEquals("3", root.data);
        assertEquals("2", root.next.data);
        assertEquals("1", root.next.next.data);
        assertNull(root.next.next.next);
    }
}
