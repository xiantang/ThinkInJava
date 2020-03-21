package design.c3;


import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: xiantang
 * @Date: 2019/9/4 11:12
 */
public class ConcurrentLinkedQueueTest {
    /**
     *
     * private static class Node<E> {
     *         volatile E item;
     *         volatile Node<E> next;
     *
     * tail 不是总在更新的
     * 而是采用一种延迟更新的方式
     * 当 tail 的下一个个节点不为null 的情况的时候
     * 会执行定位到队尾节点的操作，找到尾节点进行插入
     * 当 tail 的节点为 null 的情况的时候 只插入
     * 节点不更新tail
     * 这样达到了每插入两个元素更新CAS尾部的效果
     *
     * 为什么要这样做？
     *
     * 如果大量的入队操作，会造成大量的操作损耗
     * 这个设计就是为了减少CAS 更新的操作，大大的提升
     * 了入队的效率。
     * public boolean info.xiantang.algorithm.offer(E e) {
     *         checkNotNull(e);
     *         final Node<E> newNode = new Node<E>(e);
     *
     *         for (Node<E> t = tail, p = t;;) {
     *             Node<E> q = p.next;
     *             if (q == null) {
     *                 // p 最后一个节点
     *                 // cas 如果实际节点是null和期望节点相同
     *                 // 就将这个节点设置为新的节点
     *                 if (p.casNext(null, newNode)) {
     *                     // 每两次更新一下tail
     *                     // hop two nodes at a time
     *                     if (p != t) // hop two nodes at a time
     *                         casTail(t, newNode);  // Failure is OK.
     *                     return true;
     *                 }
     *                 // 竞争失败重试
     *             }
     *             else if (p == q)
     *                 // 如果 t 的指向被其他线程修改
     *                 // 就用新的 tail 作为末尾节点
     *                 // 如果 t == t 表明没有被修改
     *                 // 就从头部开始重新寻找尾部
     *                 p = (t != (t = tail)) ? t : head;
     *             else
     *                 // 检查tail 是否被更新
     *                 p = (p != t && t != (t = tail)) ? t : q;
     *         }
     *     }
     *
     */
    public static void main(String[] args) {


//        ConcurrentLinkedQueue linkedQueue = new ConcurrentLinkedQueue();
//        linkedQueue.info.xiantang.algorithm.offer(1);
//        linkedQueue.info.xiantang.algorithm.offer(2);


        ConcurrentLinkedQueue<String> linkedQueue = new ConcurrentLinkedQueue<>();
        linkedQueue.add("1");
        linkedQueue.poll();
        /**
         * public E poll() {
         *         restartFromHead:
         *         for (;;) {
         *             for (Node<E> h = head, p = h, q;;) {
         *                 E item = p.item;
         *
         *                 if (item != null && p.casItem(item, null)) {
         *                     // Successful CAS is the linearization point
         *                     // for item to be removed from this queue.
         *                     if (p != h) // hop two nodes at a time
         *                         updateHead(h, ((q = p.next) != null) ? q : p);
         *                     return item;
         *                 }
         *                 else if ((q = p.next) == null) {
         *                     updateHead(h, p);
         *                     return null;
         *                 }
         *                 else if (p == q)
         *                     continue restartFromHead;
         *                 else
         *                     p = q;
         *             }
         *         }
         *     }
         */

    }
}
