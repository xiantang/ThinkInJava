package info.xiantang.algorithm.offer.offer1;

import java.util.Stack;

public class No7 {
    /**
     * @param 两个栈建立队列
     * 一个存储的是栈结构，另外一个存储的是逆序的
     * 对于插入操作先插入栈中
     * 如果有一次poll 就调用On 的方式 将栈中的数据推入另一个逆序的栈中
     * 这是逆序的栈的顺序就是我们要的队列顺序
     */
    /**
     * 正
     */
    private Stack s1=new Stack();
    /**
     * 反
     */
    private Stack s2=new Stack();
    public void offer(Object x){
        s1.push(x);
    }


    /**
     * 如果两个都空说明有问题
     * 如果s2不为空就从s2 中取出一个  这样能保证队列的顺序
     * 如果s1不为空s2 为空 就把s1倒入s2中
     * @return
     * @throws Exception
     */
    public Object poll() throws Exception {

        if (s1.empty() && s2.empty()) {
            throw new Exception("队列为空");
        } else {
            if (s2.size() != 0) {
                return s2.pop();
            }
            else {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
                return s2.pop();
            }

        }

    }

    public static void main(String[] args) throws Exception {
        No7 queue=new No7();
        queue.offer("a");
        queue.offer("b");
        System.out.println(queue.poll());
        queue.offer("c");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
