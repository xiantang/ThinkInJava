package info.xiantang.algorithm.interview;

public class No15CountOneInBinary {
    public static int count(int i) {
        int count = 0;
        while (i != 0) {
            int i1 = i & 1;
            if (i1 == 1) {
                count += 1;
            }
            i = i >> 1;
        }
        return count;
    }
}
