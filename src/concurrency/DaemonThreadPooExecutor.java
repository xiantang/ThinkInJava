package concurrency;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DaemonThreadPooExecutor extends ThreadPoolExecutor {
    public DaemonThreadPooExecutor() {
        super(0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new DaemonThreadFactory());
    }

}
