package concurrency.ApplyingThreadPools;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAppThread extends Thread {
    private static final AtomicInteger created = new AtomicInteger();
    private String poolName;
    public MyAppThread(Runnable r, String poolName) {
        super(r, poolName + " - " + created.incrementAndGet());
        this.poolName = poolName;
    }

    public MyAppThread(Runnable r) {
        super(r, "bbbbb");
    }

    @Override
    public void run() {
        System.out.println(poolName + " - " + created.get());
                 super.run();
    }
}
