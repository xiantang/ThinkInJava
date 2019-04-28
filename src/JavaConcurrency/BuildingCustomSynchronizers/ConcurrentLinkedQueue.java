package JavaConcurrency.BuildingCustomSynchronizers;


import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Author: xiantang
 * @Date: 2019/4/27 20:41
 */
public class ConcurrentLinkedQueue {
    private class Node<E> {
        private final E item;
        private volatile Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    private static AtomicReferenceFieldUpdater<Node, Node> nextUpdater = AtomicReferenceFieldUpdater.newUpdater(Node.class,
            Node.class, "next");

}
