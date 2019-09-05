package design.c2;


/**
 * @Author: xiantang
 * @Date: 2019/9/4 10:51
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        /**
         *
         * public static ExecutorService newFixedThreadPool(int nThreads) {
         *         return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *     }
         *
         * public static ExecutorService newSingleThreadExecutor() {
         *         return new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         *     }
         * 没有任务的时候线程池无线程
         * 如果有大量任务被提交任务总会迫使线程池增加线程执行任务
         * public static ExecutorService newCachedThreadPool() {
         *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>());
         *     }
         *
         *
         * 线程池 execute() 方法
         *
         *         int c = ctl.get();
         *         if (workerCountOf(c) < corePoolSize) {
         *             if (addWorker(command, true))
         *                 return;
         *             c = ctl.get();
         *         }
         *         if (isRunning(c) && workQueue.offer(command)) {
         *             int recheck = ctl.get();
         *             if (! isRunning(recheck) && remove(command))
         *                 reject(command);
         *             else if (workerCountOf(recheck) == 0)
         *                 addWorker(null, false);
         *         }
         *         else if (!addWorker(command, false))
         *             reject(command);
         *
         * 如果workerCountOf(c)<corePoolSize
         * 小于核心线程数，会将任务通过addWork()方法直接调度执行
         * 否则进入等待队列
         * 如果无法进入等待队列就直接提交给线程池
         * 如果线程池已经满了就执行拒绝策略
         */
    }
}
