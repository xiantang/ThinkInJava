package al;

import java.util.List;

/**
 * @Author: xiantang
 * @Date: 2019/5/18 13:51
 */
public class DFS {
    private int res;

    public int dfs(int[][] rec, int target) {
        res = 0;
        dfs(rec, 0, 0, target);
        return res;
    }

    public void dfs(int[][] rec, int x, int y, int cur) {
        if (cur - rec[x][y] > 0) {

            if (x + 1 < rec.length) {
                int tempcur = cur - rec[x][y];
                int temp = x + 1;
                dfs(rec, temp, y, tempcur);
            }
            if (y + 1 < rec[0].length) {
                int tempcur = cur - rec[x][y];
                int temp = y + 1;
                dfs(rec, x, temp, tempcur);
            }

        } else if (cur - rec[x][y] < 0) {
            return;
        } else {
            if (x == rec.length-1 && y == rec[0].length-1) {
                res += 1;
            }

            return;
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        int[][] rec = new int[][]
                {{2,1,2},{1,1,1},{1,1,3},{2,1,1},{2,1,1}};
        int a = dfs.dfs(rec, 8);
        System.out.println(a);
    }


}
