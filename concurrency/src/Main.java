/**
 * @Author: xiantang
 * @Date: 2019/9/1 20:12
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < N; j++) {
                list.add(array[j]);
            }
            res.add(list);
        }
        int max = -1;
        for (List<Integer> list : res) {
            int min = Collections.min(list);
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            max = Math.max(min * sum, max);
        }
        System.out.println(max);

    }
}