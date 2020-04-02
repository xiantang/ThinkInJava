package info.xiantang.algorithm.interview;

public class No12HasPathInMatrix {
    public static boolean find(char[][] matrix, String str) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int[][] visited = new int[matrix.length][matrix[0].length];
                boolean result = find(matrix, i, j, str,visited);

                if (result) return true;
            }
        }
        return false;
    }

    private static boolean find(char[][] matrix, int i, int j, String str, int[][] visited) {
        if (str.length() == 0) {
            return true;
        }
        char c = str.charAt(0);
        // 先做边界检查
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1 || c != matrix[i][j] || visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1;
        return find(matrix, i + 1, j, str.substring(1), visited) || find(matrix, i - 1, j, str.substring(1), visited) || find(matrix, i, j + 1, str.substring(1), visited)
                || find(matrix, i, j -1, str.substring(1), visited);


    }
}
