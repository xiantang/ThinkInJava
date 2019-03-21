package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
//        this.len = len;
        array = new int[size];
        len = size;

        // 初始化操作
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }

    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) return true;
        }
        return false;
    }
}

class SerialNumberChecker {
    private static final int SIZE = 20;
    // 长度1000
    private static CircularSet serials =
            new CircularSet(1000);
    private static ExecutorService exec =
            Executors.newCachedThreadPool();

    // 内置的线程
    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 递增的数字
                int serial =
                        SerialNumberGenerator.nextSerialNumber();
//                System.out.println(serial);
                // 是否递增
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);

                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            // 10个线程来竞争
            exec.execute(new SerialChecker());
        }
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("NO");
            System.exit(0);
        }
    }

}