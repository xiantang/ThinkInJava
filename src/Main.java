import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    private String MSG = "Original";
    private   void addAndPrint(String head,int tail){
//        double result = addTwoTypes(1, 88.88);
//        System.out.println(result);
//        ConcurrentHashMap

//        ConcurrentHashMap<String, String> cm = new ConcurrentHashMap<String, String>();
//        for (int i = 0; i < 20; i++) {
//            cm.put((char) (i + 65) + (char) (i + 66) + (char) (i + 67) + "", i + ">>>http://blog.csdn.net/unix21/");
//        }
//        StringBuffer;
//        String
        System.out.println(head+tail);
    }

    public static double addTwoTypes(int i, double d) {
        return i + d;
    }

    public static void main(String[] args) throws Exception {
//        Main.addAndPrint();
        Main main = new Main();
        Class mClass = Main.class;
        Method priM = mClass.getDeclaredMethod("addAndPrint",String.class,int.class);
        if (priM != null) {
            priM.setAccessible(true);
            priM.invoke(main, "Java Reflect ", 666);
        }


    }
}
