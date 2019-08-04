package algorithm;

import java.util.Stack;

public class TwoStackMin {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    void put(int val) {
        if (min.isEmpty()) {
            min.push(val);
            stack.push(val);
        } else {
            // 如果最小栈的值小于val
            if (min.peek() < val) {
                min.push(min.peek());
                stack.push(val);
            } else {
                min.push(val);
                stack.push(val);
            }
        }
    }

    int peek() {
        return min.peek();
    }

    public static void main(String[] args) {
        TwoStackMin twoStackMin = new TwoStackMin();
        twoStackMin.put(1);
        System.out.println(twoStackMin.peek());
        twoStackMin.put(222);
        System.out.println(twoStackMin.peek());
        twoStackMin.put(0);
        System.out.println(twoStackMin.peek());

    }
}
