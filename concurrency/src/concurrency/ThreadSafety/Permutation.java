package concurrency.ThreadSafety;


public class Permutation {

    /**
     * s t 两个字符串长度相等，s是否是t的重排列
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return boolean 是否相等
     */
    public boolean equal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 创建一个数组去记录每个字符出现的次数
        int[] letters = new int[256];

        // 记录 s 的字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c]++;
        }

        // 遍历 t 如果 t 的字母不在 s 中存在就返回 false
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }


}
