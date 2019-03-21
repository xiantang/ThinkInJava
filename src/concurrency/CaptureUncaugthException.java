package concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new thread");
        Thread thread = new Thread(r);
        System.out.println("created " +thread);
        thread.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        return thread;
    }
}

public class CaptureUncaugthException {
    public static void main(String[] args) {
//        HandlerThreadFactory threadFactory = new HandlerThreadFactory();
//        threadFactory.newThread()
        ExecutorService executorService =
                Executors.newCachedThreadPool(new HandlerThreadFactory());
        executorService.execute(new ExceptionThread2());
    }
}
