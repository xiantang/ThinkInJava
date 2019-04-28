package JavaConcurrency.BuildingCustomSynchronizers;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: xiantang
 * @Date: 2019/4/27 14:55
 */
public class Semaphore  {

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            while (true) {
                int available = getState();
                int remaining = available - arg;
                if (remaining < 0 ||
                        compareAndSetState(available, remaining)) {
                    return remaining;
                }
            }


        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true) {
                int p = getState();
                if (compareAndSetState(p, p + 1)) {
                    return true;
                }
            }
        }


    }



}
