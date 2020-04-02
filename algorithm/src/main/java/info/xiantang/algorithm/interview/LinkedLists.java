package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;

class LinkedLists {

    /**
     * 反转链表
     * @param root
     * @return
     */
    static Node reverse(Node root) {
        Node pre = null;
        while (root != null) {
            Node next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }


    /**
     * 环检测
     * @param root
     * @return
     */
    static boolean validateCycle(Node root) {
        if (root == null) {
            return false;
        }
        Node fast = root;
        Node slow = root;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.data.equals(slow.data)) {
                return true;
            }
        }
        return false;
    }
}
