package concurrency;

class DualSynch {
    private Object sysncObject = new Object();

    // 同步整个方法
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().toString()+" f()");
            Thread.yield();
        }
    }

    public void g() {
//        synchronized (sysncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().toString()+" g()");
                Thread.yield();
//            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
