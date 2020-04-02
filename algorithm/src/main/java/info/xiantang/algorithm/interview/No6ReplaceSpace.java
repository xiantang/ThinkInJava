package info.xiantang.algorithm.interview;

class No6ReplaceSpace {
    static String replace(String s) {
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCount += 1;
            }
        }
        int newLength = s.length() + spaceCount * 2;
        char[] newString = new char[newLength];
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {

                newString[cur] = '%';
                cur += 1;
                newString[cur] = '2';
                cur += 1;
                newString[cur] = '0';
                cur += 1;
            } else {
                char c = s.charAt(i);
                newString[cur] = c;
                cur += 1;
            }
        }

        return new String(newString);
    }
}
