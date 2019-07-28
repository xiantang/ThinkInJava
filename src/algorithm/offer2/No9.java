package algorithm.offer2;

public class No9 {
    /**
     * pool solution
     *      效率极差
     *             5
     *       4          3
     *     3    2    2       1
     *   2   1 1  0 1  0
     *   O(2^n)
     * @param n
     * @return
     */
     public static int fn1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return fn1(n - 1) + fn1(n - 2);
        }
    }

    /**
     * good solution
     *从左到右依次求出每一项的值，那么通过顺序计算求得第N项即可。其时间复杂度为O(N)。
     * @param n
     * @return
     */
    public static int fn2(int n) {
        if (n < 2) {
            return n;
        }
        int fb1 = 0;
        int fb2 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = fb2;
            fb2 = fb2 + fb1;
            fb1 = tmp;
        }
        return fb2;
    }
    public static void main(String[] args) {
        System.out.println(fn2(4));
    }
}
