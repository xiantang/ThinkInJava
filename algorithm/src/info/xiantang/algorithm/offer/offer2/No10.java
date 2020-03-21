package info.xiantang.algorithm.offer.offer2;

public class No10 {
    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个n 级的台阶总共有多少种跳法。
     * 倒推做法
     * @param n
     * @return
     */
    public static int getMethodNumber(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return getMethodNumber(n - 1) + getMethodNumber(n - 2);
    }
    public static void main(String[] args) {
        System.out.println(getMethodNumber(5));;

    }
}
