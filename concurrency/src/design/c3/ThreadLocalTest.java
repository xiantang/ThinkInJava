package design.c3;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xiantang
 * @Date: 2019/9/4 19:57
 */
public class ThreadLocalTest {


    /**
     * 但是ThreadLocal又是如何实现的呢？
     * public void set(T value) {
     *         // 获得当前线程的对象
     *         Thread t = Thread.currentThread();
     *         // 获得当前线程的ThreadLocalMap
     *         // 并且这个TheadLocalMap是定义在 Thread 中的
     *         // ThreadLocal.ThreadLocalMap threadLocals = null;
     *         ThreadLocalMap map = getMap(t);
     *         if (map != null)
     *             map.set(this, value);
     *         else
     *             createMap(t, value);
     * }
     *
     *
     *
     * public T get() {
     *         Thread t = Thread.currentThread();
     *         // 将自己作为key取得内部数据
     *         ThreadLocalMap map = getMap(t);
     *         if (map != null) {
     *             ThreadLocalMap.Entry e = map.getEntry(this);
     *             if (e != null) {
     *                 @SuppressWarnings("unchecked")
     *                 T result = (T)e.value;
     *                 return result;
     *             }
     *         }
     *         return setInitialValue();
     *     }
     *
     */

    static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class ParseDate implements Runnable {
        int i = 0;

        ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (t1.get() == null) {
                    t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = t1.get().parse("2015-03-29 19:28:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
        es.shutdown();
    }


}
