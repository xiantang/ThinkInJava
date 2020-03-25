package info.xiantang.jvm.jvm;

public class Overload {
    public static void sayHello(Object arg){
        System.out.println("hello Object");
    }
//    public static void sayHello(int arg){
//        System.out.println("hello int");
//    }
//    public static void sayHello(long arg){
//        System.out.println("hello long");
//    }
//    public static void sayHello(Character arg){
//        System.out.println("hello Character");
//    }
//    public static void sayHello(char arg){
//        System.out.println("hello char");
//    }
    // 7个重载方法已经被注释得只剩一个了，可见变长参数的重载优先级是最低的，这时候
    // 字符'a'被当做了一个数组元素。
    public static void sayHello(char ...arg){
        System.out.println("hello char……");

    }
//    public static void sayHello(Serializable arg){
//        System.out.println("hello Serializable");
//    }
    public static void main(String[]args){
        //char-＞int-＞long-＞float-＞double的顺序转型进行匹配。
        //当自动装箱之后发现还是找不到装箱类，但是找到了装箱类实现了的接口类型，
        // 所以紧接着又发生一次自动转型。
        sayHello('a');
    }

}
