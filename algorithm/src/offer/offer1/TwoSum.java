package offer.offer1;

/**
 * @Author: xiantang
 * @Date: 2019/8/30 16:04
 */
public class TwoSum {
    public static class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int data) {
            super();
            this.data = data;
        }
    }

    public static void print(Node a) {
        while (a != null) {
            System.out.println(a.data);
            a = a.next;
        }
    }
    public static void twoSum(Node a, Node b) {
        a = reverse(a);
        b = reverse(b);
//        print(a);
//        print(b);

        Node dummyHead = new Node(0);
        Node cur = dummyHead;

        int carry = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;

            carry = sum / 10;
            cur.next = new Node(sum % 10);
            cur = cur.next;
            a = (a != null) ? a.next : null;
            b = (b != null) ? b.next : null;
        }
        print(reverse(dummyHead.next));

    }

    private static Node reverse(Node head) {
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(3);
        Node node3=new Node(5);
        Node node4=new Node(6);
        Node node5 = new Node(3);
        Node a=new Node(9);
        Node b=new Node(9);
        Node c=new Node(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        a.next = b;
        b.next = c;
        twoSum(node1, a);
    }
}
