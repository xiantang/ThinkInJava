package concurrency;

import com.oracle.tools.packager.mac.MacAppBundler;
import javafx.beans.binding.StringBinding;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class AB implements Runnable {
    boolean flag = false;
    public synchronized void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException e) {
            System.out.println("sleep interrupted in A");
        }
        System.out.println("A setting flag = true");
        flag = true;
    }


}

class BetterWait implements Runnable {
    private AB a = new AB();
    public synchronized AB getA() { return a; }

    public synchronized void run() {
        System.out.println("Better a.flag = " + a.flag);
        try {
            if(!a.flag) {
                System.out.println("BetterWait reset");
                // 等待 让出线程的限权
                wait();
                a.flag = false;
                System.out.println("BetterWait reset a.flag = false");
            }


        } catch(InterruptedException e) {
            System.out.println("BetterWait.run() interrupted");
        }

    }

    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        BetterWait better = new BetterWait();
//        exec.execute(better.getA());
//        exec.execute(better);


//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch(InterruptedException e) {
//            System.out.println("sleep interrupted in main()");
//        }
//        // 获取锁
//        synchronized Integer.toString(a)(better) {
//            // 激活等待的
//            better.notify();
//        }
//        exec.shutdownNow();
    }
}