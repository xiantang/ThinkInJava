package concurrency.AvoidingLivenessHazards;

import java.util.Random;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 13:30
 */
public class InduceLockOrder {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct,
                              final Account toAcct,
                              final DollarAmount amount) throws InsufficientFundsException {
        class Helper{
            public void transfer() throws InsufficientFundsException {
                if (fromAcct.getBalance().compareTo(amount) < 0) {
                    throw new InsufficientFundsException();
                } else {
                    fromAcct.debit(amount);
                    toAcct.debit(amount);
                }
            }
        }
        // 两个账户的hash 值
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);
        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATION = 100000;
    public static void main(String[] args) {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];
        for (int i = 0; i < accounts.length; i++) {
//            accounts[i]= new Account() {
//            }
        }
    }


}

interface DollarAmount extends Comparable<DollarAmount> {
}

interface Account {
    void debit(DollarAmount d);

    void credit(DollarAmount d);

    DollarAmount getBalance();

    int getAcctNo();
}

class InsufficientFundsException extends Exception {
}