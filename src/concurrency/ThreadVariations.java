package concurrency;

import java.util.concurrent.*;

class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

        }

        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }

    }

    public InnerThread1(Inner inner) {
        this.inner = inner;
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }
}

class InnerRunnable1 {

    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        this.inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread t;

        public Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }


        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
        }

        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }
}

class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(this);
                            if (--countDown == 0) return;
                            sleep(10);
                        } catch (InterruptedException e) {
                            System.out.println("interrupted");
                        }
                    }
                }

                @Override
                public String toString() {
                    return getName() + ": " + countDown;
                }
            };
            t.start();
        }
    }

    public Future<Integer> runTask(int n) {

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> res = exec.submit(new Callable<Integer>() {
            public int get(int n) {
                if (n < 2) {
                    return 1;
                }
                return get(n - 2) + get(n - 1);
            }


            @Override
            public Integer call() throws Exception {
                return get(n);
            }
        });
        exec.shutdown();

        return res;

    }

}

public class ThreadVariations {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new ThreadMethod("ThreadMethod").runTask();
        Future<Integer> future = new ThreadMethod("dasda").runTask(4);
        System.out.println(future.get());

    }
}
