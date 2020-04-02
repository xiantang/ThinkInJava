package info.xiantang.algorithm.interview;

import java.util.Stack;

class N9Queue<T> {

    private Stack<T> inStack = new Stack<>();
    private Stack<T> outStack = new Stack<>();


    void appendTail(T element) {
        inStack.push(element);
    }

    T deleteHead() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }
}
