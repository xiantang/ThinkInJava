package info.xiantang.algorithm.collection.base;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AlgorithmTest {
    private static class Algorithm {

        //第一题. 合并时间区间(建议时间复杂度 O(n) )
        static int[][] merge(int[][] a) {
            // 用一个栈来合并区间
            Stack<Object> stack = new Stack<>();
            for (int i = 0; i < a.length; i++) {
                int[] cur = a[i];
                if (i == 0) {
                    stack.push(cur);
                } else {
                    int[] pop = (int[]) stack.pop();
                    if (pop[1] >= cur[0]) {
                        stack.push(new int[]{pop[0], cur[1]});
                    } else {
                        stack.push(pop);
                        stack.push(cur);
                    }
                }
            }
            List<List<Integer>> lists = new ArrayList<>();
            while (!stack.isEmpty()) {
                List<Integer> list = Ints.asList((int[]) stack.pop());
                lists.add(list);
            }
            Collections.reverse(lists);
            return lists.stream()
                    .map(list -> list.stream().mapToInt(i -> i).toArray())
                    .toArray(int[][]::new);
        }

        //第二题. 缩写校验(建议时间复杂度 O(n) )
        static boolean valid(String word, String abbr) {
            int currWord = 0;
            int currAbbr = 0;
            int wordl = word.length();
            int abbrl = abbr.length();
            // 两个指针分别指向word 和 abbr
            while (currWord < wordl && currAbbr < abbrl) {
                if (word.charAt(currWord) == abbr.charAt(currAbbr)) {
                    currWord++;
                    currAbbr++;
                } else if (Character.isDigit(abbr.charAt(currAbbr))) {
                    int start = currAbbr;
                    while (Character.isDigit(abbr.charAt(currAbbr + 1))) {
                        currAbbr += 1;
                    }
                    String substring = abbr.substring(start, currAbbr + 1);
                    int i = Integer.parseInt(substring);
                    currAbbr += 1;
                    currWord += i;
                } else {
                    return false;
                }
            }
            return true;
        }


    }

    //  第三题.不会做.

    @org.junit.Test
    public void testMerge() {
        int[][] a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] actual = Algorithm.merge(a);
        int[][] expect = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expect,actual);
        int[][] b = new int[][]{{1, 4}, {4, 5}};
        int[][] actual1 = Algorithm.merge(b);
        int[][] expect1 = new int[][]{{1, 5}};
        assertArrayEquals(expect1,actual1);

    }




    @org.junit.Test
    public void testShortValidate() {
        boolean res1 = Algorithm.valid("internationalization", "i12iz4n");
        assertTrue(res1);
        boolean res2 = Algorithm.valid("apple", "a2e");
        assertFalse(res2);

    }



}
