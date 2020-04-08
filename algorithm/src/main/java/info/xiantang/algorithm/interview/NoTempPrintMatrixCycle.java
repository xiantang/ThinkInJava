package info.xiantang.algorithm.interview;

class NoTempPrintMatrixCycle {
    static void cycle(int[][] array) {
        int target = array.length / 2;
        print(array, 0, target);
    }

    private static void print(int[][] array, int start, int target) {
        if (start == target) {
            return;
        }


        for (int i = start; i < array.length - start; i++) {
            System.out.print(array[start][i]+" ");
        }
        System.out.println();

        for (int i = start+1; i < array.length - start; i++) {
            System.out.print(array[i][array.length - start-1]+" ");
        }
        System.out.println();

        for (int i = array.length - start -2; i >=start; i--) {
            System.out.print(array[array.length - start - 1][i] +" ");
        }
        System.out.println();

        for (int i = array.length - start -2; i >start; i--) {
            System.out.print(array[i][start] +" ");
        }

        System.out.println();

        print(array, start + 1, target);
    }
}
