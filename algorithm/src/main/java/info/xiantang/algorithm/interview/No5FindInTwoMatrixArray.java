package info.xiantang.algorithm.interview;

public class No5FindInTwoMatrixArray {
    public static boolean find(int[][] arr,int target) {
        int a = arr.length;
        int b = arr[0].length;
        int i = 0;
        int j = b - 1;
        while (i < a && j >= 0) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[j][i] > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }
}
