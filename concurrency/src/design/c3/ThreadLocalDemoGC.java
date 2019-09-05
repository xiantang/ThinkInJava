package design.c3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 10:18
 */
public class ThreadLocalDemoGC {
    /**
     * 。WeakReference标志性的特点是：reference实例不会影响到被应用对象的GC回收行为
     * （即只要对象被除WeakReference对象之外所有的对象解除引用后，该对象便可以被GC回收），
     * 只不过在被对象回收之后，reference实例想获得被应用的对象时程序会返回null。
     *
     * 这里虽然使用 ThreadLocal 作为key
     * 但是实际上不是真正持有ThreadLocal
     * static class Entry extends WeakReference<ThreadLocal<?>> {
     *   Object value;
     *   Entry(ThreadLocal<?> k, Object v) {
     *       super(k);
     *       value = v;
     *   }
     * }
     *
     */



    static volatile ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString() + " is gc");
    }

    static volatile CountDownLatch cd = new CountDownLatch(10000);

    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + " is gc ");
                        }
                    });
                    System.out.println(Thread.currentThread().getId() + ":create SimpleDateFormat");
                }
                Date t = tl.get().parse("2015-03-29 19:29:" + i % 60);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                cd.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }
        cd.await();

        System.out.println("mission complete");
        tl = null;
        System.gc();
        System.out.println("first gc complete");
        tl = new ThreadLocal<>();
        cd = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }
        cd.await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second gc complete");
    }
}
