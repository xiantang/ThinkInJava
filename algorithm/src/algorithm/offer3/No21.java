package algorithm.offer3;

public class No21 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到
     * 栈的最小元素的 min 函数。
     * 在该栈中，调用 min、push 以及 pop 的时间复杂度都是 O(1)。
     */
    public static void main(String[] args) {
        MyStack a = new MyStack();

        a.push(10);
        System.out.println(a.min());
        a.push(11);
        System.out.println(a.min());
        a.push(9);
        System.out.println(a.min());
        a.pop();
        System.out.println(a.min());
    }
}
