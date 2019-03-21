package concurrency;


import java.util.concurrent.TimeUnit;

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted." +
                    "isInterrupted():" + isInterrupted());
            e.printStackTrace();
            return;
        }
        System.out.println(getName() + "has awakened");
    }
}

public class Joinning extends Thread {
    private Sleeper sleeper;

    public Joinning(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " join completed");
    }

    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joinning
                dopey = new Joinning("Dopey", sleepy),
                doc = new Joinning("doc", grumpy);
        grumpy.interrupt();
    }
}
