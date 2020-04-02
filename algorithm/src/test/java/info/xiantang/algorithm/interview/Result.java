package info.xiantang.algorithm.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Result {

    /**
     * 找出字符串中出现次数最多的字母，次数相同的情况下返回ascii code更小的，没有字母的话返回null(忽略大小写，统一当成小写处理).
     *
     * <p>
     * 提示:
     * 1. 字符串长度在1000以内，且只包含ascii字符
     * </p>
     *
     * @param string 只包含ascii字符的字符串.
     * @return 出现次数最多的字母.
     */

    public static Character mostFrequentLetter(String string) {
        // TODO: 实现这个方法
        if ("".equals(string)) {
            return null;
        }
        string = string.toLowerCase();
        Map<Character, Integer> mapper = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if (Character.isAlphabetic(c)) {
                Integer integer = mapper.get(c);
                if (integer == null) {
                    mapper.put(c, 1);
                } else {
                    integer += 1;
                    mapper.put(c, integer);
                }
            }
        }

        int max = -1;
        Character res = null;
        Iterator<Map.Entry<Character, Integer>> iterator = mapper.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() > max) {
                max = next.getValue();
                res = next.getKey();
            } else if (next.getValue() == max && next.getKey() < res) {
                max = next.getValue();
                res = next.getKey();
            }
        }

        return res;
    }

}
