package info.xiantang.jvm.jvm;

public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }
    static  class PRMXS extends Human  {
        protected  void sayHello() {
            System.out.println("PRMXS say hello");
        }
    }

    static class Man extends PRMXS {

    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("Woman say hello");
        }
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();

        /*
         16: aload_1
         17: invokevirtual #6                  // Method jvm/DynamicDispatch$Human.sayHello:()V
         */
        // 1 找到操作数栈上的第一个元素所指向的对象的实际类型
        // 2 如果找到就判断是否可以被访问 可以被访问就返回直接引用
        // 3 否则就自下向上对各个父类进行第二步的搜索和验证
        // 4 如果没有找到则抛出java.lang.AbstractMethodError异常
        man.sayHello();
        /*
         20: aload_2
         21: invokevirtual #6                  // Method jvm/DynamicDispatch$Human.sayHello:()V
         */
        woman.sayHello();
        man = new Woman();
        man.sayHello();

    }
}
