package info.xiantang.algorithm.offer.offer1;

import java.util.Objects;

public class Node<T> {
    public T data;
    public Node<T> next;




    public Node(T data) {
        super();
        this.data = data;
    }
    public Node(T data, Node<T> next) {
        super();
        this.data = data;
        this.next = next;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
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
