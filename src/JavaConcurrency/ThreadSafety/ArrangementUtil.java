package JavaConcurrency.ThreadSafety;

import java.util.LinkedList;
import java.util.List;

public class ArrangementUtil {
    private static List<String> result;


    /**
     * 返回指定字符序列的全排列
     * @param str 字符串str
     * @return 字符串的全排列
     */
    public static List<String> getFullArrangement(char[] str) {
        result = new LinkedList<String>();
        if (str == null) {
            return null;
        }
        // 获得所有排列
        fullArrangement(str, str, 0);
        List<String> destList = new LinkedList<String>();
        // 返回拷贝
        destList.addAll(result);
        return destList;
    }


    private static void fullArrangement(char[] str, char[] begin, int startIndex) {
        if (startIndex == str.length) {
            result.add(String.valueOf(str));
        } else {
            for (int i = startIndex; i < str.length; i++) {
                char temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;
                fullArrangement(str, begin, startIndex + 1);
                temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;
            }
        }
    }

}
