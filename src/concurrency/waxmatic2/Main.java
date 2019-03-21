package concurrency.waxmatic2;

public class Main {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void start() {

        for (int i = 0; i < 10; i++) {
            final int a = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //向当前线程中存储数据
                    threadLocal.set(a);
                    //获取当前线程中的数据
                    threadLocal.get();
                    //删除当前线程中的数据
                    threadLocal.remove();
                }
            }).start();

        }
    }

    public static void main(String[] args) {
        new Main().start();
    }

}
