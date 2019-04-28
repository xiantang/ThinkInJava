package JavaConcurrency.ExplicitLocks;


import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 15:48
 */
public class DeadlockAvoidance {
    private static Random rnd = new Random();

    public boolean transferMoney(Account fromAcct,
                                 Account toAcct,
                                 DollarAmount amount,
                                 long timeout,
                                 TimeUnit unit
    ) throws InsufficientFundsException, InterruptedException {

        long fixedDelay = getFixedDelayComponentNanos(timeout, unit);
        long randMod = getRandomDelayModulusNanos(timeout, unit);
        long stopTime = System.nanoTime() + unit.toNanos(timeout);
        while (true) {
            if (fromAcct.lock.tryLock()) {
                try {
                    if (toAcct.lock.tryLock()) {
                        try {
                            if (fromAcct.getBalance().compareTo(amount) < 0) {
                                throw new InsufficientFundsException();
                            } else {
                                fromAcct.debit(amount);
                                toAcct.credit(amount);
                            }
                        }finally {
                            toAcct.lock.unlock();
                        }
                    }
                }finally {
                    fromAcct.lock.unlock();

                }
            }
            if (System.nanoTime() < stopTime) {
                return false;
            }
            NANOSECONDS.sleep(fixedDelay + rnd.nextLong() % randMod);


        }

    }

    private static final int DELAY_FIXED = 1;
    private static final int DELAY_RANDOM = 2;
    static long getFixedDelayComponentNanos(long timeout, TimeUnit unit) {
        return DELAY_FIXED;
    }

    static long getRandomDelayModulusNanos(long timeout, TimeUnit unit) {
        return DELAY_RANDOM;
    }



    class Account {
        public Lock lock;

        void debit(DollarAmount d) {
        }

        void credit(DollarAmount d) {
        }

        DollarAmount getBalance() {
            return null;
        }
    }
    static class DollarAmount implements Comparable<DollarAmount> {
        @Override
        public int compareTo(DollarAmount other) {
            return 0;
        }

        DollarAmount(int dollars) {
        }
    }
    class InsufficientFundsException extends Exception {
    }
}
