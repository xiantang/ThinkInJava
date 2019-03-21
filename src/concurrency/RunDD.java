package concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Message {
    private String msg;

    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String str) {
        this.msg=str;
    }

}
public class RunDD implements Runnable {
    Message message;
    public RunDD(Message m){
        this.message=m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try {
                System.out.println(name + " is waiting");
                // 交出锁
                message.wait();
                System.out.println(name + " is getting the message");
                System.out.println(name + " get " + message.getMsg());
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
//                e.printStackTrace();
            }

        }
    }
}

 class RunGG implements Runnable {
    Message message;
    public RunGG(Message m){
        this.message=m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            message.notifyAll();
            message.setMsg(name+ "   xiantang");
        }
    }

     public static void main(String[] args) {
         ExecutorService exec = Executors.newCachedThreadPool();
         Message message = new Message("fdsfdsf");
         exec.execute(new RunDD(message));
         exec.execute(new RunDD(message));

         exec.execute(new RunGG(message));
         try {
             TimeUnit.SECONDS.sleep(5);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         exec.shutdownNow();
     }
}
