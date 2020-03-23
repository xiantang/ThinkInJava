package info.xiantang.concurrency.TaskExecution;

import java.util.concurrent.Executor;

public class ThradPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
