package concurrency.CancellationAndShutdown;

public class Worker implements Runnable {
    public void run() {

        System.out.println(Thread.currentThread().getName() + " is running");

    }

    public static void main(String[] args) {
//        int corePoolSize = 5;
//
//        int maxPoolSize = 10;
//
//        long keepAliveTime = 5;
//
//        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);
//
//
//        RejectedExecutionHandler handler =
//
//                new ThreadPoolExecutor.CallerRunsPolicy();
//
//        ThreadPoolExecutor executor = new ThreadPoolExecutor
//
//                (corePoolSize, maxPoolSize,
//
//                        keepAliveTime, TimeUnit.SECONDS,
//
//                        queue, handler);
//
//        for (int i = 0; i < 100; i++) {
//
//            executor.execute(new Worker());
//
//        }
//
//        executor.shutdown();

        double result = 1.0 - 0.9;
        System.out.println(result);
        
    }


}


