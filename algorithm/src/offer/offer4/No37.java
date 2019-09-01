package offer.offer4;


/**
 * @Author: xiantang
 * @Date: 2019/7/30 23:24
 */
public class No37 {


    /**
     * 输入两个单向链表，找出它们的第一个公共结点。
     * 使两边同步 让长的先走一段路 然后同时走 同时比较
     */
    // TODO 需要review



    static class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int data) {
            super();
            this.data = data;
        }

        public Node(int data, Node next) {
            super();
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
    public static void main(String[] args) {
        Node head1 = new Node();
        Node second1 = new Node();
        Node third1 = new Node();
        Node forth1 = new Node();
        Node fifth1 = new Node();
        Node head2 = new Node();
        Node second2 = new Node();
        Node third2 = new Node();
        Node forth2 = new Node();
        head1.next = second1;
        second1.next = third1;
        third1.next = forth1;
        forth1.next = fifth1;
        head2.next = second2;
        second2.next = forth1;
        third2.next = fifth1;
        head1.data = 1;
        second1.data = 2;
        third1.data = 3;
        forth1.data = 6;
        fifth1.data = 7;
        head2.data = 4;
        second2.data = 5;
        third2.data = 6;
        forth2.data = 7;
        System.out.println(findFirstCommonNode(head1, head2).data);
    }

    private static Node findFirstCommonNode(Node head1, Node head2) {
        Node tmpHead1 = head1;
        int count1 = 0;
        Node tmpHead2 = head2;
        int count2 = 0;
        while (tmpHead1 != null) {
            tmpHead1 = tmpHead1.next;
            count1 += 1;
        }
        while (tmpHead2 != null) {
            tmpHead2 = tmpHead2.next;
            count2 += 1;
        }
        Node longList;
        Node shotList;
        int range;
        if (count1 > count2) {
            longList = head1;
            shotList = head2;
            range = count1 - count2;
        } else if (count1 < count2) {
            longList = head2;
            shotList = head1;
            range = count2 - count1;
        } else {
            longList = head1;
            shotList = head1;
            range = 0;
        }
        while (range > 0) {
            longList = longList.next;
            range -= 1;
        }
        while (longList != null) {
            if (longList == shotList) {
                return longList;
            } else {
                longList = longList.next;
                shotList = shotList.next;
            }
        }
        return null;

    }
}
