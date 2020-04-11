package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;

public class No23FindLinkedListEntrance {
    public static Node<Integer> find(Node<Integer> root) {
        Node<Integer> fast = root;
        Node<Integer> slow = root;
        // 找到交点
        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                break;
            }
        }

        // 求出环的长度
        int count = 1;
        Node<Integer> preFast = fast;
        fast = fast.next;
        while (fast != preFast) {
            fast = fast.next;
            count += 1;
        }
        fast = root;
        slow = root;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        while (!slow.equals(fast)) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
