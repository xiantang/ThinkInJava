package info.xiantang.algorithm.offer.offer4;

/**
 * @Author: xiantang
 * @Date: 2019/7/31 21:08
 */
public class No42 {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点
     符号和普通字母一样处理。
     * 例如输入字符串"I am student."，则输出"student. a am I"
     */
    public static void main(String[] args) {
        String string="I am a student.";
        reverseSentence(string);
    }

    private static void reverseSentence(String string) {
        String[] strings = string.split(" ");
        int start = 0;
        int end = strings.length - 1;
        while (start < end) {
            String tmp = strings[end];
            strings[end] = strings[start];
            strings[start] = tmp;
            start++;
            end--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if (i == 0) {
                sb.append(strings[i]);
            } else {
                sb.append(" ").append(strings[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
