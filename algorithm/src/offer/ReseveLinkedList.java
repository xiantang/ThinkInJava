package offer;


/**
 * @Author: xiantang
 * @Date: 2019/7/14 12:50
 */


public class ReseveLinkedList {

    private class LinkNode {
        private int val;
        public LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    void re() {
        LinkNode a = new LinkNode(1);
        LinkNode b = new LinkNode(2);
        LinkNode c = new LinkNode(3);
        LinkNode d = new LinkNode(4);
        LinkNode root = a;
        root.next = b;
        b.next = c;
        c.next = d;
        LinkNode pre = null;
        while (root != null) {
            LinkNode next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }


    }

    public static void main(String[] args) {
        new ReseveLinkedList().re();

    }

}
