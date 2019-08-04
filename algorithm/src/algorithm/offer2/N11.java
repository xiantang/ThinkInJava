package algorithm.offer2;

public class N11 {
    /**
     * 请实现一个函数，输入一个整数，
     * 输出该二进制表示中 1 的个数。
     * 例如把 9 表示成二进制是 1001， 有 2 位是 1。
     * 因此如果输入 9，该函数输出 2。
     */
    public static int numberOf1(int n) {
        int count = 0;
        while (n>0) {
            if ((n & 1)!=1) {
                count += 1;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(9));
    }
}
