package info.xiantang.concurrency.AtomicVariablesAndNonblockingSynchronization;



import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: xiantang
 * @Date: 2019/4/27 19:54
 */


class Node<E> {
    public final E item;
    public Node<E> next;

    public Node(E item) {
        this.item = item;
    }
}
public class ConcurrentStack <E>{
    AtomicReference<Node<E>> top = new AtomicReference<Node<E>>();

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        Node<E> oldHead;
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }


    public E pop() {
        Node<E> newHead;
        Node<E> oldHead;
        do {
            oldHead = top.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

    public static void main(String[] args) {
        ConcurrentStack<Integer> concurrentStack = new ConcurrentStack<Integer>();
        concurrentStack.push(1);
        concurrentStack.push(2);
        System.out.println(concurrentStack.pop());
        System.out.println(concurrentStack.pop());

    }
}
