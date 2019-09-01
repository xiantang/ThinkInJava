package offer.sort;


/**
 * @Author: xiantang
 * @Date: 2019/9/1 17:26
 */
public class Queue {
    private int[] elements;

    private int head;

    private int tail;
    public Queue(int initialCapacity) {

        elements = new int[initialCapacity];
    }

    public void push(int val) throws Exception {
        boolean isFull = tail > head && (tail - head) % elements.length == 0;
        if (!isFull) {
            elements[tail % elements.length] = val;
            tail += 1;
        } else {
            throw new Exception("");
        }
    }

    public int pop() throws Exception {
        boolean isEmpty = tail == head;
        int result=0;
        if (!isEmpty) {
            result =elements[head % elements.length];
            elements[head % elements.length] = 0;
            head++;
        }else {
            throw new Exception("");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);
        queue.push(111);
        queue.push(2222);
        queue.push(333);
        System.out.println(queue.pop());
        queue.push(444);
        queue.push(444);
        queue.push(444);
    }
}
