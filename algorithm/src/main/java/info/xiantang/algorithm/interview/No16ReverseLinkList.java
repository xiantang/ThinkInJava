package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;

public class No16ReverseLinkList {
    public static Node reverse(Node root) {
        // 1 ->2 ->3
        Node pre = null;
        while (root != null) {
            Node next = root.next;
            root.next = pre;
            pre = root;
            root = next;

        }

        return pre;
    }
}
