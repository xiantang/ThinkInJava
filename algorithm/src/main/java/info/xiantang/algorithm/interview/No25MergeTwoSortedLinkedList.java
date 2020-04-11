package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.offer.offer1.Node;

class No25MergeTwoSortedLinkedList {
    static Node<Integer> merge(Node<Integer> root1, Node<Integer> root2) {

        Node<Integer> tmp = new Node<>(-1);
        Node<Integer> root = tmp;


        while (root1 != null && root2 != null) {
            if (root1.data > root2.data) {
                root.next = root2;
                root2 = root2.next;

            } else {
                root.next = root1;
                root1 = root1.next;
            }
            root = root.next;
        }

        if (root1 != null) {
            root.next = root1;
        }
        if (root2 != null) {
            root.next = root2;
        }


        return tmp.next;
    }
}
