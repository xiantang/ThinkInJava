package jvm;

public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }
    public void sayHello(Human guy){
        System.out.println("hello,guy！");
    }
    public void sayHello(Man guy){
        System.out.println("hello,gentleman！");
    }
    public void sayHello(Woman guy){
        System.out.println("hello,lady！");
    }
    public static void main(String[]args){
        // Human 静态类型 Man 实际类型
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        // 虚拟机在重载的时候是通过静态类型来判断的
        // 静态分派发生在编译阶段
        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);

    }

}
