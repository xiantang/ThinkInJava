package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Tree {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (Character.isAlphabetic(a) || a == '[' || a == '|' || Character.isDigit(a)) {
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
                } while (c != '[');
                StringBuilder res = new StringBuilder();
                int num = Integer.parseInt(ints.reverse().toString());
                strs = strs.reverse();
                for (int j = 0; j < num; j++) {
                    res.append(strs);
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
