package concurrency;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

class NeedCleanUp {
    private final int id;

    public NeedCleanUp(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }

    void cleanup() {
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {

        Deque deque = new LinkedList<String>();
        

    }
}

public class InterruptingIdiom {
    public static void main(String[] args) {
        System.out.println("a".substring(1));
    }
}
