package info.xiantang.concurrency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class MonitoringTest {
    private static void createBusyThread(){
        Thread thread=new Thread(() -> {
            while(true)//第41行
            {
            }
        },"testBusyThread");
        thread.start();
    }
    /**
     *线程锁等待演示
     */
    private static void createLockThread(final Object lock){
        Thread thread=new Thread(() -> {
            synchronized(lock){
                try{
                    System.out.println(111);
                    lock.wait();
                    System.out.println(222);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"testLockThread");
        thread.start();
    }
    public static void main(String[]args)throws Exception{
        new BufferedReader(new InputStreamReader(System.in));

        createBusyThread();
        Object obj=new Object();
        createLockThread(obj);
        TimeUnit.SECONDS.sleep(2);
        createLockThread(obj);

    }

}
