package info.xiantang.algorithm.interview;

public class N13RobotMoveRangeCount {
    public static int count(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return count(threshold, 0, 0, visited);
    }

    private static int count(int threshold, int rows, int cols, boolean[][] visited) {
        if (rows > visited.length - 1 || cols > visited[0].length-1 || rows < 0 || cols < 0 || visited[rows][cols]) {
            return 0;
        }
        visited[rows][cols] = true;
        int sum = getSum(rows) + getSum(cols);
        int count = 0;
        if (threshold >= sum) {
            count += 1;
        }
        return count + count(threshold, rows + 1, cols, visited) +
                count(threshold, rows - 1, cols, visited) +
                count(threshold, rows, cols + 1, visited)+
                count(threshold, rows, cols - 1, visited);
    }

    private static int getSum(int i) {
        String s = String.valueOf(i);
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            String substring = s.substring(j, j + 1);
            sum += Integer.parseInt(substring);
        }
        return sum;
    }

}
