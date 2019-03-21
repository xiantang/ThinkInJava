package concurrency;

public class LIftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    // final 初始化不允许被更改
    private final int id = taskCount++;

    public LIftOff() {
    }

    public LIftOff(int countDown) {
        this.countDown = countDown;
    }


    public String status() {
        return "#" + id+"（"+(countDown>0?countDown:"Liftoff!")+"),";
    }
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
//        Runnable runnable = new LIftOff();
//        runnable.run();
//        Thread t = new Thread(new LIftOff());
//        t.start();
//        Thread s = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        });
//        s.start();
//        System.out.println("waiting");
        for (int i = 0; i < 5; i++) {
            new Thread(new LIftOff()).start();

        }
        System.out.println("wait");
    }

}
