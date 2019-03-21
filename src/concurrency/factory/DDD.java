package concurrency.factory;

public class DDD implements Runnable {

    static int i = 0;

    public static synchronized void increase() {
        // 不具备原子性
        // 先读取值
        // 写回新值期间读取i的域值
        i++;
    }
    

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        DDD ddd1 = new DDD();
        DDD ddd2 = new DDD();
        Thread t1=new Thread(ddd1);
        Thread t2=new Thread(ddd2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }
}
