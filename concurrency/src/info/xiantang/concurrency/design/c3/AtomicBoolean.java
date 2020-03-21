package info.xiantang.concurrency.design.c3;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 13:19
 */
public class AtomicBoolean {
    // setup to use Unsafe.compareAndSwapInt for updates
    private static final Unsafe unsafe = getUnsafeInstance();
    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (AtomicBoolean.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile int value;

    private static final long valueOffset;

    //使用方法
    private static Unsafe getUnsafeInstance(){
        Field theUnsafeInstance = null;
        try {
            theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        theUnsafeInstance.setAccessible(true);
        try {
            return (Unsafe) theUnsafeInstance.get(Unsafe.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AtomicBoolean(int value) {
        this.value = value;
    }

    public boolean getValue() {
        return value != 0;
    }

    public boolean setAndGet(boolean update) {
        while (true) {
            int u = update ? 1 : 0;
            if (unsafe.compareAndSwapInt(this, valueOffset, this.value, u)) {
                return update;
            }
        }
    }

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(1);
        System.out.println(atomicBoolean.getValue());
        atomicBoolean.setAndGet(false);
        System.out.println(atomicBoolean.getValue());
    }
}
