package design.c4.jdk;

import java.util.concurrent.*;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 16:05
 */
public class RealData implements Callable<String> {
    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            Thread.sleep(100);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<>(new RealData("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(future);

        System.out.println("请求完毕");
        Thread.sleep(2000);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
