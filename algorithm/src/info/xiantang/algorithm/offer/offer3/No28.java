package info.xiantang.algorithm.offer.offer3;

public class No28 {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 例如输入字符串 abc， 则打印出由字符串 a、b、c 所能
     * 排列出来的所有字符串 abc、acb、bac、bca、cab 和 cba
     */
    // TODO 需要复习一下 这个是道好题

    /**
     *     画一画递归树
     *                 *
     *     a->a       a->b         a->c
     *     abc        bac          cba
     * b->b    b->c a->a   a->c   b->b   b->a
     * abc     acb  bac    bca    cba    cab
     * @param args
     */

    public static void main(String[] args) {

    }

    private static void myPrint(String str) {
        if (str == null) {
            return;
        }
        char[] chs = str.toCharArray();
        myPrint(chs, 0);
    }

    private static void myPrint(char[] str, int i) {
        if (i >= str.length) {
            return;
        }
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
            return;
        }

        for (int j = i; j < str.length; j++) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            myPrint(str, i + 1);
            tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }


}
