package concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiantang
 * @Date: 2019/7/11 22:00
 */
public class Test implements Runnable {

    private  volatile int num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            num++;
            /*int a = num;
            a = a + 1;
            num = a;*/
        }
        //System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
//        Test demo = new Test();
//
//        Thread demo1 = new Thread(demo);
//        Thread demo2 = new Thread(demo);
//        Thread demo3 = new Thread(demo);
//
//        demo1.start();
//        demo2.start();
//        demo3.start();
//
//        demo1.join();
//        demo2.join();
//        demo3.join();
//        System.out.println(demo.num);

//        Map config;
//        char[] configText;
//        volatile boolean inited = false;
//        // 线程A
//        config = new HashMap();
//        configText = readConfigFile(fileName);
//        processConfigOptions(configText, configOptions);
//        inited = true;
//        // 线程B
//        while(!inited){
//            sleep();
//        }
//
//        doSomethingWithConfig();
    }
}
