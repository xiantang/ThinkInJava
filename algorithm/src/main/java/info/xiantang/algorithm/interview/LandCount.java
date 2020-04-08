package info.xiantang.algorithm.interview;

public class LandCount {
    public static int find(int[][] lands) {
        int sum = 0;
        for (int i = 0; i < lands.length; i++) {
            for (int j = 0; j < lands[i].length; j++) {
                if (lands[i][j] == 1) {
                    sum += 1;
                    find(lands, i, j);
                }


            }
        }
        return sum;
    }

    private static void find(int[][] lands, int i, int j) {
        if (i < 0 || j < 0 || i >= lands.length || j >= lands.length) {
            return;
        }
        if (lands[i][j] == 0) {
            return;
        }
        lands[i][j] = 0;
        find(lands, i + 1, j);
        find(lands, i - 1, j);
        find(lands, i, j + 1);
        find(lands, i, j - 1);


    }
}
