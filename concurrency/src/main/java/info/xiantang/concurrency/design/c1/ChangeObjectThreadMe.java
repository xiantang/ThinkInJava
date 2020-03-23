package info.xiantang.concurrency.design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 10:49
 */
public class ChangeObjectThreadMe extends Thread {
    public static User u = new User();

    public static class User {
        private int id;
        private String name;

        public User() {
            this.id = 0;
            this.name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ",name=" + name + "]";
        }
    }

    private volatile boolean stopme = false;

    public void stopMe() {
        stopme = true;
    }


    @Override
    public void run() {
        while (true) {
            // 进入这里才会停止线程
            // 然后不会进入 synchronized 临界区内部
            // 所以状态仍然正确
            if (stopme) {
                System.out.println("exit by stop me");
                break;
            }
            synchronized (u) {
                int v = (int) (System.currentTimeMillis() / 1000);
                u.setId(v);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                u.setName(String.valueOf(v));
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThreadMe thread = new ChangeObjectThreadMe();
        thread.start();
        Thread.sleep(3009);
        thread.stopMe();
        Thread.sleep(3009);
    }
}
