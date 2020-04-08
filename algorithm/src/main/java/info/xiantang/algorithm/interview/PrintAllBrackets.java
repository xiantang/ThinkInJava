package info.xiantang.algorithm.interview;

public class PrintAllBrackets {
    public static void print(int count) {
        backtrack(count, 0, 0,"");
    }

    private static void backtrack(int count, int left, int right,String str) {
        if (left == count && right == count) {
            System.out.println(str);
            return;
        }
        if(right < left){
            backtrack(count, left, right + 1, str + ")");
        }
        if (left < count ) {
            backtrack(count,left+1,right,str+"(");
        }

    }
}
