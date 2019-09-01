package offer.offer1;

public class Node {
    public String data;
    public Node next;

    public Node() {
    }

    public Node(String data) {
        super();
        this.data = data;
    }
    public Node(String data, Node next) {
        super();
        this.data = data;
        this.next = next;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

}
