package algorithm.offer1;

public class No5 {
    private static Node reverse2(Node head) {
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 非常巧妙的做法 使用回溯的做法
     * 先遍历到底部
     * 然后通过当前节点和之前节点反转的做法来走
     * head.next.next = head;
     * head.next = null;
     */
    private static Node reserse1(Node head) {
        if (head.next == null) {
            return head;
        }
        Node reverseHead = reserse1(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }


    public static void main(String[] args) {
        Node node1=new Node("A");
        Node node2=new Node("B");
        Node node3=new Node("C");
        Node node4=new Node("D");
        Node node5=new Node("E");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        reserse1(node1);
        reverse2(node1);
    }
}
