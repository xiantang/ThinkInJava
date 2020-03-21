package info.xiantang.concurrency.design.c1;

import java.util.ArrayList;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 14:36
 */
public class ArrayListMultiThread {
    static ArrayList<Integer> al = new ArrayList<>();

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}
