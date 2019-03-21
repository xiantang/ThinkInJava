package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {
    private final int orderNum;
    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;
    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
//                TimeUnit.SECONDS.sleep(1);

                synchronized (this) {
                    // 其他任务可能会被唤醒 突然拿走订单
                    while (restaurant.meal == null) {
//                    TimeUnit.SECONDS.sleep(1);
                        wait();
                    }
                }
                System.out.println("Waitperson got " + restaurant.meal);

                // 先获取busBoy
                synchronized (restaurant.busBoy) {

                    restaurant.busBoy.notifyAll();
                }
//                System.out.println(1);
                synchronized (this) {

                    wait();
                }

            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }

}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 如果菜肴存在就等待
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                // 如果大于10 就推出
                if (++count == 10) {
                    System.out.println("Out of food.close");
                    restaurant.exec.shutdownNow();
//                    return;
                }
                System.out.println("Order up!");
                // 锁住侍从
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");


        }
    }
}

class BusBoy implements Runnable{
    private Restaurant restaurant;
    public BusBoy(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 等待
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("Clean up!");
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                synchronized (restaurant.waitPerson) {
//                    restaurant.meal = null;
                    restaurant.waitPerson.notifyAll();
                }
            }

        } catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}
public class Restaurant {
     Meal meal;

    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    BusBoy busBoy = new BusBoy(this);

    public Restaurant() {
        exec.execute(busBoy);
        exec.execute(chef);
        exec.execute(waitPerson);

    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
