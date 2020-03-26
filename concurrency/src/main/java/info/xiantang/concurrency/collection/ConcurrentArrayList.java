package info.xiantang.concurrency.collection;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentArrayList<T> {
    private int size;
    private Object[] elements;
    private AtomicInteger writeCursor = new AtomicInteger(-1);

    ConcurrentArrayList(int size) {
        this.size = size;
        this.elements = new Object[size];
    }

    public void add(T element) {
        int current;
        int next;
        do {
            current = writeCursor.get();
            next = current + 1;
        } while (!writeCursor.compareAndSet(current, next));
        elements[next] = element;
    }

    void addAll(List<T> list) {
        int size = list.size();
        int current;
        int next;
        do {
            current = writeCursor.get();
            next = current + size;
        } while (!writeCursor.compareAndSet(current, next));
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            elements[current + i + 1] = item;
        }
    }

    int getWriteCursor() {
        return writeCursor.get();
    }
}
