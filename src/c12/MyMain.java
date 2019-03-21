package c12;

public class MyMain {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("stack overflow");


        while(true){


            Thread th = new Thread(new Runnable(){

                @Override
                public void run() {
                    while(true){
                        System.out.println("do not stop");
                    }
                }

            });
            th.start();

        }

    }
}
