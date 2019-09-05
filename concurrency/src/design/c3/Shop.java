package design.c3;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 13:41
 */
public class Shop {
    static AtomicReference<Integer> money = new AtomicReference<>();

    public static void main(String[] args) {
        money.set(19);
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        Integer m = money.get();
                        if (m < 20) {

                            if (money.compareAndSet(m, m + 20)) {
                                System.out.println("余额小于20元，余额:" + money.get() + "元");
                                break;
                            }
                        } else {
                            System.out.println("余额大于20元，无需");
                            break;
                        }
                    }
                }
            }.start();
        }


        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        Integer m = money.get();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10)) {
                                System.out.println("成功消费10元");
                                break;
                            }
                        } else {
                            System.out.println("没有足够余额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
