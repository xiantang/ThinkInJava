package info.xiantang.jvm.jvm;

public class StaticResolution {
    public static void sayHello() {
        System.out.println("sayHello");

    }

    public final int a() {
        System.out.println(111);
        return 11;
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
        new StaticResolution().a();
    }
}
