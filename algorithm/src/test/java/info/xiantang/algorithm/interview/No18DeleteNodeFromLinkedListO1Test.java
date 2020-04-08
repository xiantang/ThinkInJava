package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No18DeleteNodeFromLinkedListO1Test {
    @Test
    public void testNodeInMid() {
        Node a = new Node("1");
        Node b = new Node("2");
        Node c = new Node("3");
        Node d = new Node("4");
        Node e = new Node("5");
        Node f = new Node("6");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        No18DeleteNodeFromLinkedListO1.delete(a, c);
        Node a1 = new Node("1");
        Node b1 = new Node("2");
        Node d1 = new Node("4");
        Node e1 = new Node("5");
        Node f1 = new Node("6");
        a1.setNext(b1);
        b1.setNext(d1);
        d1.setNext(e1);
        e1.setNext(f1);
        assertEquals(a1, a);
    }

    @Test
    public void testNodeInHead() {
        Node a = new Node("1");
        Node b = new Node("2");
        Node c = new Node("3");
        Node d = new Node("4");
        Node e = new Node("5");
        Node f = new Node("6");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        Node delete = No18DeleteNodeFromLinkedListO1.delete(a, a);

        Node b1 = new Node("2");
        Node c1 = new Node("3");
        Node d1 = new Node("4");
        Node e1 = new Node("5");
        Node f1 = new Node("6");
        b1.setNext(c1);
        c1.setNext(d1);
        d1.setNext(e1);
        e1.setNext(f1);
        assertEquals(b1, delete);
    }

    @Test
    public void testNodeInTail() {
        Node a = new Node("1");
        Node b = new Node("2");
        Node c = new Node("3");
        Node d = new Node("4");
        Node e = new Node("5");
        Node f = new Node("6");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        Node delete = No18DeleteNodeFromLinkedListO1.delete(a, f);
        Node a1 = new Node("1");
        Node b1 = new Node("2");
        Node c1 = new Node("3");
        Node d1 = new Node("4");
        Node e1 = new Node("5");
        a1.setNext(b1);
        b1.setNext(c1);
        c1.setNext(d1);
        d1.setNext(e1);
        assertEquals(a1, delete);
    }


}
