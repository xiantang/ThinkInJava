package design.c3;



import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 特点是按照需求动态的扩展其内部的空间
 * @Author: xiantang
 * @Date: 2019/9/5 14:03
 */
public class LockFreeVector<E> {
    private static final int N_BUCKET = 30;
    private static final int FIRST_BUCKET_SIZE = 8;

    /**
     * 这些数组都是CAS的原子数组
     * 为了拓展空间方便 使用二维的
     */
    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
    private final AtomicReference<Descriptor<E>> descriptor;

    public LockFreeVector() {
        // 30 个数组
        buckets = new AtomicReferenceArray<>(N_BUCKET);
        buckets.set(0, new AtomicReferenceArray<E>(FIRST_BUCKET_SIZE));
        descriptor = new AtomicReference<>(new Descriptor<E>(0, null));
    }


    public void pushBack(E e) {

    }

    static class Descriptor<E> {
        public int size;
        volatile WriteDescriptor<E> writeop;

        public Descriptor(int size, WriteDescriptor<E> writeop) {
            this.size = size;
            this.writeop = writeop;
        }

        public void completeWrite() {
            WriteDescriptor<E> tmpOp = writeop;
            if (tmpOp != null) {
                tmpOp.doIt();
                writeop = null;

            }
        }
    }


    static class WriteDescriptor<E> {
        public AtomicReferenceArray<E> addr;
        public int addInd;
        public E oldV;
        public E newV;


        public WriteDescriptor(AtomicReferenceArray<E> add, int addInd, E oldV, E newV) {
            this.addr = add;
            this.addInd = addInd;
            this.oldV = oldV;
            this.newV = newV;
        }

        public void doIt() {
            addr.compareAndSet(addInd, oldV, newV);
        }
    }


}