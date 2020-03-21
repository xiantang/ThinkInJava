package info.xiantang.algorithm.book.find;

import info.xiantang.algorithm.book.algs4.ST;
import info.xiantang.algorithm.book.algs4.StdIn;
import info.xiantang.algorithm.book.algs4.StdOut;

public class StTest {
    public static void main(String[] args){
        ST<String,Integer>st;
        st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key,i);
        }
        for (String s:st.keys()
             ) {
            StdOut.println(s+"  "+st.get(s));
        }
    }
}
