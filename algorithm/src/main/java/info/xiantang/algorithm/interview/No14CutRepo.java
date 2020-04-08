package info.xiantang.algorithm.interview;

public class No14CutRepo {

    public static int cut(int length) {
        int[] lengths = new int[length + 1];
        lengths[0] = 0;
        lengths[1] = 1;
        lengths[2] = 2;
        lengths[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int products = Math.max(max, lengths[j] * lengths[i - j]);
                if (products > max) {
                    max = products;
                }
                lengths[i] = max;
            }
        }


        return lengths[length];
    }

}
