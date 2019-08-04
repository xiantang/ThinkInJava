package algorithm;

/**
 * @Author: xiantang
 * @Date: 2019/7/8 8:35
 */
public class FindLongestSubString {
    public static void main(String[] args) {
        String test = "aaaebc";
        int len = test.length();
        String maxString = "";
        String subString = "";
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                subString = test.substring(i, j);
                if (j == len) {
                    if (subString.length() > maxString.length()) {
                        maxString = subString;
                    }
                }
                else {
                    if (subString.indexOf(test.substring(j, j + 1)) > -1) {
                        if (subString.length() > maxString.length()) {
                            maxString = subString;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(maxString);

    }
}
