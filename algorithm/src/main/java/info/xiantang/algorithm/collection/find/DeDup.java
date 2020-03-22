package info.xiantang.algorithm.collection.find;

import info.xiantang.algorithm.collection.algs4.StdIn;
import info.xiantang.algorithm.collection.algs4.StdOut;

import java.util.HashSet;

public class DeDup {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<String>();
        while (!StdIn.isEmpty()){
            String key = StdIn.readString();
            if (!set.contains(key)){
                set.add(key);
                StdOut.print(key+" ");
            }
        }
    }
}
