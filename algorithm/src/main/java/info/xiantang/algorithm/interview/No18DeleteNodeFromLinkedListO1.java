package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;

public class No18DeleteNodeFromLinkedListO1 {
    public static Node delete(Node root, Node target) {

        // 如果这个节点是头节点
        if (target.equals(root)) {
            root = root.next;
            return root;
        }
        // 如果这个节点在中间
        else if (target.next != null) {
            Node next = target.next;
            target.next = next.next;
            target.data = next.data;
            return root;
        }
        // 如果这个节点在末尾
        else {
            Node a = root;
            while (root.next != null) {
                Node next = root.next;
                if (next.equals(target)) {
                    root.next = null;
                    break;
                }
                root = root.next;

            }
            return a;
        }

    }
}
