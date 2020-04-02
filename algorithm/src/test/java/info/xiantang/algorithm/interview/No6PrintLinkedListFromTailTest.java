package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;
import org.junit.Test;

public class No6PrintLinkedListFromTailTest {

    @Test
    public void printLinkedListFromTailTest() {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        No7PrintLinkedListFromTail.print(node1);
    }


    @Test
    public void printLinkedListFromTailUseStack() {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        No7PrintLinkedListFromTail.printUseStack(node1);
    }


}
