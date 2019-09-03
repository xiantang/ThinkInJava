package design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 14:26
 */
public class NoVisibility {
    private volatile static boolean ready;
    private static int number;

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);
    }


}
