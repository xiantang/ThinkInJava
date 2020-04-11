package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;

public class LastKNodeInLinkedList {
    public static Node<Integer> find(Node<Integer> root, int k) {
        if (root == null) {
            return null;
        }

        Node<Integer> fast = root;
        Node<Integer> slow = root;
        while (k != 0) {
            k -= 1;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }


        return slow;
    }
}
