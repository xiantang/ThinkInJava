package info.xiantang.jvm.dynamicsupport;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author: xiantang
 * @Date: 2019/8/28 10:41
 */
public class GrandFather {

    void thinking(){
        System.out.println("i am grandfather");
    }
    static class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    static class Son extends Father {
        void thinking() {
            try{
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            }catch(Throwable e){
            }

        }


    }
    public static void main(String[] args) {
        new Son().thinking();
    }
}
