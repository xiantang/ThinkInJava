package info.xiantang.concurrency.ThreadSafety;

public class LazyInitRace {
    public static void Permutation(char[] str) {
        if (str == null) {
            return;
        }

        Permutation(str, str, 0);
    }

    public static void Permutation(char[] str, char[] begin, int startIndex) {
        if (startIndex == str.length) {
            System.out.println(str);
        } else {
            for (int i = startIndex; i < str.length; i++) {
                char temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;

                Permutation(str, begin, startIndex + 1);

                temp = begin[i];
                begin[i] = begin[startIndex];
                begin[startIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(1111);
    }
//    public static void main(String[] args) {
//        LazyInitRace.Permutation("sadas".toCharArray());
//    }
}

class ExpensiveObject {

}