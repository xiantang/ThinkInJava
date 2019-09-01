package offer.offer1;

public class No4 {
    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。
     * 例如输入"We are happy"，则输出"We%20are%20happy"
     */
    public static void main(String[] args) {
        String str="We are happy";
        char[] charArray = str.toCharArray();
        System.out.println(change(charArray));
    }

    /**
     * On 的时间复杂度实现 拷贝一个 添加好%20的空数组
     * 分别定义两个索引在后方
     * a,b
     * 如果为空格就将 a a-1 a-2 替换为%20 并且将 a -1 b也-1
     * @param charArray
     * @return
     */
    private static String change(char[] charArray) {
        int count = 0;
        for (char a : charArray) {
            if (a == ' ') {
                count += 1;
            }
        }
        // 因为要删除一个空格
        char[] temp = new char[count * 2 + charArray.length];
        int a = temp.length-1;
        int b = charArray.length-1;
        while (a >= 0) {
            if (charArray[b] == ' ') {
                temp[a] = '0';
                temp[a - 1] = '2';
                temp[a - 2] = '%';
                a = a - 3;
            } else {
                temp[a] = charArray[b];
                a--;
            }
            b--;
        }


        return new String(temp);
    }

}
