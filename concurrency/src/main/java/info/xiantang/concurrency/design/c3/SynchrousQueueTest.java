package info.xiantang.concurrency.design.c3;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 14:50
 */
public class SynchrousQueueTest {
    /**
     * 将put 和 take 两个截然不同的操作
     * 抽象成一个共通的方法 Transferer.transfer()
     * Object transfer(Object e, boolean timed, long nanos)
     * 如果e不为空就将当前操作传递给消费者
     * 如果e 为空就表示当前操作需要请求一个数据
     *
     *
     * int mode = (e == null) ? REQUEST : DATA;
     *
     * 如果e == null 则为Request操作 请求数据
     * e ！= null 则为 DATA 放入数据
     *
     *              // 如果队列为空
     *              if (h == null || h.mode == mode) {  // empty or same-mode
     *                     if (timed && nanos <= 0) {      // 不进行等待
     *                         if (h != null && h.isCancelled())
     *                             casHead(h, h.next);     // pop cancelled node
     *                         else
     *                             return null;
     *                     } else if (casHead(h, s = snode(s, e, h, mode))) {
     *                     // 自旋等待
     *                         SNode m = awaitFulfill(s, timed, nanos); // 等待直到匹配操作出现
     *                         if (m == s) {               // 等待操作被取消
     *                             clean(s);
     *                             return null;
     *                         }
     *                         if ((h = head) != null && h.next == s)
     *                             casHead(h, s.next);     // help s's fulfiller
     *                         return (mode == REQUEST) ? m.item : s.item;
     *                     }
     *              }
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
//        SynchronousQueue
        final SynchronousQueue<Integer> integers = new SynchronousQueue<>();

        new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(integers.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        integers.put(111);




    }
}
