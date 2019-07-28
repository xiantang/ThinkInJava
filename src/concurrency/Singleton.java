package concurrency;

/**
 * @Author: xiantang
 * @Date: 2019/7/12 23:53
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            /**
             * 0x01a3de0f：mov$0x3375cdb0，%esi；……beb0cd75 33 ；{oop（'Singleton'）}
             * 0x01a3de14：mov%eax，0x150（%esi）；……89865001 0000
             * 0x01a3de1a：shr$0x9，%esi；……c1ee09
             * 0x01a3de1d：movb$0x0，0x1104800（%esi）；……c6860048 100100
             * 0x01a3de24：lock addl$0x0，（%esp）；……f0830424 00 ；*putstatic instance ；-
             * Singleton：getInstance@24
             */
            // 多执行了一个lock addl$0x0，（%esp) 操作
            // 其中的 add 的作用是讲将Cache写入内存
            // 并且无效化别的CPU 的 Cache
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
