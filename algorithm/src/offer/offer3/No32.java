package offer.offer3;

/**
 * @Author: xiantang
 * @Date: 2019/7/30 23:08
 */
public class No32 {
    /**
     * 输入一个整数 n，求从 1 到 n 这 n 个整数的十进制表示中 1 出现的次数。
     * 例如输入 12，从 1 到 12 这些整数中包含 1 的数字有 1,10,11 和 12,1 一共出现 5 次。
     */
    public static void main(String[] args) {
        System.out.println(countOne(115));
    }

    private static long countOne(int n) {
        long count =0;
        long i=1;
        long current=0,after=0,before=0;
        while((n/i)!=0){
            current=(n/i)%10;
            before=n/(i*10);
            after=n-(n/i)*i;
            if (current > 1) {
                count = count + (before + 1) * i;
            } else if (current == 0) {
                count = count + before * i;
            } else if (current == 1) {
                count = count + before * i + after + 1;
            }
            i=i*10;
        }
        return count;
    }
}
