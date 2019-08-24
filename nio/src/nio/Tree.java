package NIO;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Tree {
    public static void main(String[] args) {

//        int[] l = {2, 7, 5, 2, 6, 0, 9, 0, 0, 5, 11,0,0, 4, 0};
//        int length = l.length;
//        int len = 1;
//        int deep = 1;
//        int pre = 1;
//        while (len != length) {
//            int tmp = pre * 2;
//            len += tmp;
//            deep += 1;
//            pre = tmp;
//        }
//        int length_ = length - 1;
//        int cur;
//        while (deep >= 0) {
//            int index = (int) Math.pow(2, (double) deep-1);
//            cur = length_ - index;
//            for (int i = cur+1; i <= length_; i++) {
//                System.out.print(l[i]);
//            }
//            System.out.println("");
//            length_ = cur;
//            deep--;
//        }
        //HG[3|B[2|CA]]F

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> characters = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            Character a = input.charAt(i);
            if (Character.isAlphabetic(a) || a.charValue() == '[' || a.charValue() == '|' || Character.isDigit(a)) {
                characters.push(a);
            } else {
                StringBuilder strs = new StringBuilder();
                StringBuilder ints = new StringBuilder();
                Character c;
                do {
                    c = characters.pop();
                    if (Character.isAlphabetic(c)) {
                        strs.append(c);
                    } else if (Character.isDigit(c)) {
                        ints.append(c);
                    }
                } while (c.charValue() != '[');
                String res = "";
                int num = Integer.parseInt(ints.reverse().toString());
                strs = strs.reverse();
                for (int j = 0; j < num; j++) {
                    res += strs;
                }
                for (int j = 0; j < res.length(); j++) {
                    Character b = res.charAt(j);
                    characters.push(b);
                }
            }
        }
        StringBuilder s = new StringBuilder();
        int size = characters.size();
        for (int i = 0; i < size; i++) {
            s.append(characters.pop());
        }
        System.out.println(s.reverse().toString());
    }
}
