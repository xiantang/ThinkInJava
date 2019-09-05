package design.c3;


import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xiantang
 * @Date: 2019/9/4 19:31
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        /**
         * public V put(K key, V value) {
         *         Segment<K,V> s;
         *         if (value == null)
         *             throw new NullPointerException();
         *5        int hash = hash(key);
         *         // 根据key找到对应段的序号
         *6        int j = (hash >>> segmentShift) & segmentMask;
         *         if ((s = (Segment<K,V>)UNSAFE.getObject          // nonvolatile; recheck
         *              (segments, (j << SSHIFT) + SBASE)) == null) //  in ensureSegment
         *             // 将数据插入到给定的段中
         *9            s = ensureSegment(j);
         *         return s.put(key, hash, value, false);
         *     }
         *
         *
         * 降低锁的粒度会引入一个新的问题
         * 当系统需要全局锁的时候，消耗的资源会比较多
         *
         * public int size() {
         *         // Try a few times to get accurate count. On failure due to
         *         // continuous async changes in table, resort to locking.
         *         final Segment<K,V>[] segments = this.segments;
         *         int size;
         *         boolean overflow; // true if size overflows 32 bits
         *         long sum;         // sum of modCounts
         *         long last = 0L;   // previous sum
         *         int retries = -1; // first iteration isn't retry
         *         try {
         *             for (;;) {
         *                 if (retries++ == RETRIES_BEFORE_LOCK) {
         *                     // 对所有段加锁
         *                     for (int j = 0; j < segments.length; ++j)
         *                         ensureSegment(j).lock(); // force creation
         *                 }
         *                 sum = 0L;
         *                 size = 0;
         *                 overflow = false;
         *                 for (int j = 0; j < segments.length; ++j) {
         *                     Segment<K,V> seg = segmentAt(segments, j);
         *                     if (seg != null) {
         *                     // 统计总数
         *                         sum += seg.modCount;
         *                         int c = seg.count;
         *                         if (c < 0 || (size += c) < 0)
         *                             overflow = true;
         *                     }
         *                 }
         *                 if (sum == last)
         *                     break;
         *                 last = sum;
         *             }
         *         } finally {
         *             if (retries > RETRIES_BEFORE_LOCK) {
         *                 // 释放所有锁
         *                 for (int j = 0; j < segments.length; ++j)
         *                     segmentAt(segments, j).unlock();
         *             }
         *         }
         *         return overflow ? Integer.MAX_VALUE : size;
         *     }
         * 所以在高并发的环境下 size() 的性能要差于同步的HashMap
         */
    }
}
