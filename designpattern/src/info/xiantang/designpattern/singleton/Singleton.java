package info.xiantang.designpattern.singleton;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 9:35
 */
public class Singleton {
    private static final Singleton instance;
//    private static final Singleton instance = new Singleton();
    static {
        instance = new Singleton();
    }

    private Singleton() {}
    public static  Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

    }
}
