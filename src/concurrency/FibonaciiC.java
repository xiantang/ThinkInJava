package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class FC implements Callable {
    private int n;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public FC(int n) {
//        System.out.println(n);

        this.n = n;
    }
    private int fib(int n) {
        if(n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }
    @Override
    public Object call() throws Exception {

        return fib(n)+"#"+id;
    }
}
public class FibonaciiC implements Runnable {
    private int n;
    private static int taskCount = 0;
    private final int id = taskCount++;
//    private ArrayList<Integer> count;
    public FibonaciiC(int n) {

        this.n = n;
    }

    private int fib(int n) {
        if(n < 2) {
//            System.out.print(1+ " ");
            return 1;
        }
//        System.out.print(res+ " ");
        return fib(n - 2) + fib(n - 1);
    }
    @Override
    public void run() {
        for(int i = 0; i < n; i++) {
            System.out.println("#" + id + " : " + fib(i));
            Thread.yield();
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i <10 ; i++) {
//            new Thread(new FibonaciiC(7)).start();
//        }
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> result =
                new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(exec.submit(new FC(30)));
        }
        for (Future<Integer> fs : result
        ) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }

        }
     }
}
