package offer.offer3;

import java.util.Stack;

public class No22 {
    /**
     * .输入两个整数序列，第一个序列表示栈的压入顺序，
     * 请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列 1、2、3、4、5 是某栈
     * 的压栈序列，序列 4、5、3、2、1 是该压栈序列对应的一个弹出序列
     * 但 4、3、5、1、2 就不可能是该压栈序列的弹出序列
     */
    // TODO 需要复习
    public static void main(String[] args) {
        Integer[] pushOrder={1,2,3,4,5};
        Integer[] popOrder={4,5,3,2,1};
        System.out.println(isRight1(pushOrder,popOrder,5));
    }

    private static boolean isRight(Integer[] pushOrder, Integer[] popOrder, int n) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < popOrder.length; i++) {
            if (!stack.isEmpty() && (int) stack.peek() == popOrder[i]) {
                stack.pop();
            } else {
                if (count == popOrder.length) {
                    return false;
                }
                do {
                    stack.push(pushOrder[count++]);
                } while ((int)stack.peek()!= popOrder[i]&&count!=pushOrder.length);

                if ((int) stack.peek() == popOrder[i]) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean isRight1(Integer[] pushOrder, Integer[] popOrder, int n) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < popOrder.length; i++) {
            if (!stack.empty() && stack.peek().intValue() == popOrder[i]) {
                stack.pop();
            } else {
                do {
                    stack.push(pushOrder[count++]);
                } while ((int) stack.peek() != popOrder[i] && count != pushOrder.length);
                if ((int) stack.peek() == popOrder[i]) {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
