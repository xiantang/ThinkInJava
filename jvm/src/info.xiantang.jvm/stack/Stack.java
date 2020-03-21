package jvm.stack;

/**
 * @Author: xiantang
 * @Date: 2019/8/28 10:52
 */
public class Stack {
    public int calc() {
        // stack=2, locals=4, args_size=1
        // 需要深度为 2 的操作数栈和 4 个 slot 的局部变量空间
        //         0: bipush        100   bipush 将单字节的整形变量推入操作数栈
        //         2: istore_1            存入局部变量表的第一个slot
        //         3: sipush        200
        //         6: istore_2
        //         7: sipush        300
        //        10: istore_3
        //        11: iload_1             将局部变量表中的slot1 压入操作数栈
        //        12: iload_2             将局部变量表中的slot2 压入操作数栈
        //        13: iadd                将两个栈顶元素出栈，做整形加法
        //        14: iload_3
        //        15: imul
        //        16: ireturn
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }

}
