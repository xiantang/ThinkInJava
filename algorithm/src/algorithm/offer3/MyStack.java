package algorithm.offer3;

import java.util.Stack;

public class MyStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public void push(int i) {
        if (stack.empty()&&minStack.empty()) {
            minStack.push(i);
            stack.push(i);
            return;
        }
        int min = minStack.peek();
        if (min > i) {
            stack.push(i);
            minStack.push(i);
        } else {
            stack.push(i);
            minStack.push(min);
        }
    }

    public int min() {
        return minStack.peek();
    }

    public int pop() {
        minStack.pop();
        return stack.pop();

    }

}
