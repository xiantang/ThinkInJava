package info.xiantang.concurrency.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAbc {

    private static int count = 0;
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    public static class AbcPrinter extends Thread {
        private char alpha;

        public AbcPrinter(char alpha) {
            this.alpha = alpha;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (count % 3 == alpha - 97) {
                    System.out.println(alpha);
                    count += 1;
                    condition.signalAll();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();

            }
        }
    }

    public static void main(String[] args) {
        new AbcPrinter('a').start();
        new AbcPrinter('b').start();
        new AbcPrinter('c').start();

    }


}
