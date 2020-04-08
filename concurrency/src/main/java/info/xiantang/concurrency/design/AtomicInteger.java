package info.xiantang.concurrency.design;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class AtomicInteger {
    private static final Unsafe unsafe = getUnsafeInstance();

    private static long offset;

    static {
        try {
            offset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    private volatile int value;

    AtomicInteger(int value) {
        this.value = value;
    }

    //使用方法
    private static Unsafe getUnsafeInstance() {
        Field unsafeInstance;
        try {
            unsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeInstance.setAccessible(true);
            return (Unsafe) unsafeInstance.get(Unsafe.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    int incrementAndGet() {
        int curr;
        int next;
        do {
            curr = get();
            next = curr + 1;
        } while (!unsafe.compareAndSwapInt(this, offset, curr, next));

        return get();
    }

    public int get() {
        return value;
    }
}
