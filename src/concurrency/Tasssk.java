package concurrency;

import java.util.concurrent.TimeUnit;

class A {
    public void dd()  {

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println(1);
        }


    }
}
public class Tasssk {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread() {
            @Override
            public void run() {
                new A().dd();
            }
        };
        a.start();
        TimeUnit.SECONDS.sleep(1);
        a.interrupt();
    }
}
