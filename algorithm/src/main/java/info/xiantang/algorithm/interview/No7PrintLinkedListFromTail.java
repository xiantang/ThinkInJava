package info.xiantang.algorithm.interview;

import info.xiantang.algorithm.collection.base.Stack;
import info.xiantang.algorithm.offer.offer1.Node;

public class No7PrintLinkedListFromTail {
    public static void print(Node root) {
        if (root != null) {
            print(root.next);
            System.out.println(root.data);
        }

    }

    static void printUseStack(Node root) {
        Stack<Node> nodes = new Stack<>();
        while (root != null) {
            nodes.push(root);
            root = root.next;
        }
        while (!nodes.isEmpty()) {
            System.out.println(nodes.pop().data);
        }
    }
}
