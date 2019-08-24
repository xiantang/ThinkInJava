package algorithm.offer3;

public class No20 {
    /** need to reveiw
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     */
    // TODO 需要复习 这个递归用的很好
    public static void main(String[] args) {
        int[][] a=create(5,5);
//        print(a);
        clockWisePrint1(a,0,4);
    }

    private static void clockWisePrint(int[][] a, int i, int j) {
        if (i == j) {
            System.out.println(a[i][j] + " ");
            return;
        }
        if (i > j) {
            return;
        }
        int x = i;
        while (x <= j) {
            System.out.println(a[i][x] + " ");
            x++;
        }
        int y = i + 1;
        while (y <= j) {
            System.out.println(a[y][j] + " ");
            y++;
        }
        x = j - 1;
        while (x >= i) {
            System.out.println(a[j][x] + " ");
            x--;
        }
        y = j - 1;
        while (y >= i+1) {
            System.out.println(a[y][i] + " ");
            y--;
        }

        clockWisePrint(a,i+1,j-1);



    }

    private static void clockWisePrint1(int[][] a, int i, int j) {
        if (i == j) {
            System.out.print(a[i][j]+ " ");
            return;
        }
        if (i > j) {
            return;
        }
        int x = i;
        while (x <= j) {
            System.out.print(a[i][x] + " ");
            x++;
        }
        int y = i + 1;
        while (y <= j) {
            System.out.print(a[y][j] + " ");
            y++;
        }
        x = j-1;
        while (x >= i) {
            System.out.print(a[j][x] + " ");
            x--;
        }
        y = j - 1;
        while (y >= i+1) {
            System.out.print(a[y][i] + " ");
            y--;
        }
        clockWisePrint1(a, i + 1, j - 1);
    }

    private static void print(int[][] a) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] create(int row, int line) {
        int[][] a=new int[row][line];
        int num=1;
        for(int i=0;i<row;i++){
            for(int j=0;j<line;j++){
                a[i][j]=num++;
            }
        }
        return a;
    }
}
