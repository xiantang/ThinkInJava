package info.xiantang.concurrency;

/**
 * @Author: xiantang
 * @Date: 2019/7/14 0:40
 */
public class Philosopher  implements Runnable  {
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((int) (Math.random() * 10));
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Thinking
                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + ": Picked up left fork.");
                    synchronized (rightFork) {
                        // Eating
                        doAction(System.nanoTime() + ": Picked up right fork - eating.");
                        // Finish eating
                        doAction(System.nanoTime() + ": Put down right fork.");
                    }
                    // Back to thinking.
                    doAction(System.nanoTime() + ": Put down left fork. Back to thinking.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];
        for (int i = 0; i < forks.length; i++)
            forks[i] = new Object();
        // 循环等待
        // 占用等待
        // 不可抢占
        // 互斥
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
            philosophers[i] = new Philosopher(leftFork, rightFork);
            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }

    }
}
