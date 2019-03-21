package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 记录花园参观者的主技术值
class Count {
    private int count = 0;
    private Random random = new Random(47);

    public synchronized int increment() {
        int temp = count;
        // 大约有一半的机会让步
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }

}

class Entrance implements Runnable {
    // 当作一个静态域存储
    private static Count count = new Count();
    private static List<Entrance> entrances =
            new ArrayList<>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total:" + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
                break;
            }
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance en : entrances
        ) {
            sum += en.getValue();
        }
        return sum;
    }
}


public class OrnametalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            // 执行Entrance
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
//        Entrance.cancel();
//        exec.shutdown();
        exec.shutdownNow();
        if (!exec.awaitTermination(300, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        System.out.println("total :" + Entrance.getTotalCount());
        System.out.println("sum " +Entrance.sumEntrances());
    }


}
