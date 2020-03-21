package info.xiantang.concurrency.ThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * corePoolSize 线程池的基本大小
 * maximumPoolSize 线程池最大线程大小
 * keepAliveTime 和 unit 则是线程空闲后的存活时间。
 * workQueue 用于存放任务的阻塞队列。
 * handler 当队列和最大线程池都满了之后的饱和策略。
 * 线程池所定义的状态，这些状态都和线程执行密切相关
 *     private static final int RUNNING    = -1 << COUNT_BITS;
 *     private static final int SHUTDOWN   =  0 << COUNT_BITS;
 *     private static final int STOP       =  1 << COUNT_BITS;
 *     private static final int TIDYING    =  2 << COUNT_BITS;
 *     private static final int TERMINATED =  3 << COUNT_BITS;
 *  RUNNING 自然是运行状态，指可以接受任务执行队列里的任务
 *  SHUTDOWN 指调用了 shutdown() 方法，不再接受新任务了，但是队列里的任务得执行完毕。
 *  STOP 指调用了 shutdownNow() 方法，不再接受新任务，同时抛弃阻塞队列里的所有任务并中断所有正在执行任务。
 *  TIDYING 所有任务都执行完毕，在调用 shutdown()/shutdownNow() 中都会尝试更新为这个状态。
 *  TERMINATED 终止状态，当执行 terminated() 后会更新为这个状态。
 *
 */
public class Test {

    public static void main(String[] args) {


    }
}
