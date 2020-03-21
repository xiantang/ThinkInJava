package info.xiantang.algorithm.offer.offer2;

import info.xiantang.algorithm.offer.offer1.Node;

public class No15 {

    /**
     * 输入一个链表，输出该链表中倒数第 K 个结点。
     * 为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾结点是倒数第 1 个结点。
     * 例如一个链表有 6 个结点，从头结点开始它们的值依次是 1,2,3,4,5,6。
     * 这个链表的倒数第 3 个结点是值为 4 的结点。
     * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于 k，输入的 k 参数为 0）
     */
    public static void main(String[] args) {
        Node a=new Node("1");
        Node b=new Node("2");
        Node c=new Node("3");
        Node d=new Node("4");
        Node e=new Node("5");
        Node f=new Node("6");
        a.setNext(b);b.setNext(c);c.setNext(d);
        d.setNext(e);e.setNext(f);
        System.out.print(FindDataFromTail(a,6).getData());
    }

    private static Node FindDataFromTail(Node a, int i) {
        Node fast = a;
        Node slow = a;
        for (int j = 0; j < i; j++) {
            fast = fast.getNext();
        }
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}
