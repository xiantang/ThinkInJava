package info.xiantang.algorithm.offer.offer4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: xiantang
 * @Date: 2019/7/30 23:18
 */
public class No35 {
    /**
     * 在字符串中找出第一个只出现一次的字符。
     * 如输入"abaccdeff"，则输出'b'
     */
    public static void main(String[] args) {
        System.out.println(firstOnceNumber("abaccdeff"));
    }

    private static Character firstOnceNumber(String abaccdeff) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < abaccdeff.length(); i++) {
            char c = abaccdeff.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, count + 1);
            } 
        }
        for (char key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return null;
    }

}
