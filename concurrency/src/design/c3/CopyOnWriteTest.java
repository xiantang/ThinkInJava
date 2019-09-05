package design.c3;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: xiantang
 * @Date: 2019/9/4 13:29
 */
public class CopyOnWriteTest {

    public static void main(String[] args) {
//        CopyOnWriteArrayList
        /**
         *
         * // 标记成 volatile 能保证修改完之后
         * // 读取线程能立马察觉到修改
         * private transient volatile Object[] array;
         *
         * 读取操作
         * public E get(int index) {
         *         return get(getArray(), index);
         * }
         *
         * final Object[] getArray() {
         *         return array;
         * }
         *
         * private E get(Object[] a, int index) {
         *         return (E) a[index];
         * }
         *
         * 写入操作
         *
         * public boolean add(E e) {
         *         // 写入操作使用锁
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             // 对于数组内部数据进行拷贝
         *07           Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             // 使用新的数组替换老的数组
         *             // 修改完之后读取线程能够立即察觉到
         *             // 这个修改 array 是 volatile
         *09           setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         *
         *
         */
    }
}
