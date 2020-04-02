package info.xiantang.algorithm.offer.offer1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

}
