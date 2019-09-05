package offer.offer1;

public class No3 {
/**
 * 在一个二维数组中，每一行都按照从左到右递增
 * 的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组
 * 和一个整数，判断数组中是否函数该整数。
 */
    public static boolean search(int[][] arr, int value) {

        // TODO need to review
        // 从右上脚开始搜索
        // 先找9 如果比9大就在
        //{2, 4, 9, 12},
        //{4, 7, 10, 13},
        //{6, 8, 11, 15}
        // 里面找
        // 因为{1, 2, 8, 9}都小于或者等于9
        // 如果比9小 就在
        // {{1, 2, 8},
        // {2, 4, 9},
        // {4, 7, 13},
        // {6, 8, 11};
        // 里面找
        int a = arr[0].length;
        int b = arr.length;
        int i = 0;
        int j = a - 1;
        while (i < b - 1 && j >= 0) {
            if (arr[i][j] == value) {
                return true;
            } else if (arr[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr =  {{1, 2, 8, 9},
                        {2, 4, 9, 12},
                        {4, 7, 10, 13},
                        {6, 8, 11, 15}};
        System.out.println(search(arr, 7));

    }
}
