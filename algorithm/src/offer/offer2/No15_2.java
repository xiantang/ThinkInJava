package offer.offer2;

import offer.offer1.Node;

public class No15_2 {
    /**
     * 求链表的中间结点。如果链表中结点总数为奇数，
     * 返回中间结点；如果结点总数为偶数，返回中间两个结点的任意一个
     */
    public static void main(String[] args) {
            Node a=new Node("1");
            Node b=new Node("2");
            Node c=new Node("3");
            Node d=new Node("4");
            Node e=new Node("5");
            Node f=new Node("6");
            Node g=new Node("7");
            a.setNext(b);b.setNext(c);c.setNext(d);
            d.setNext(e);e.setNext(f);f.setNext(g);
            Node mid=getMid(a);
            System.out.println(mid.getData());

    }

    private static Node getMid(Node a) {
        if(a==null){
            return null;
        }
        Node slow=a;
        Node fast=a;
        while(fast.getNext()!=null&&fast.getNext().getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        return slow;

    }
}
