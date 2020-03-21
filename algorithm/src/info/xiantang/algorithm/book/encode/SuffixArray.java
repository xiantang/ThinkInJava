package info.xiantang.algorithm.book.encode;

import info.xiantang.algorithm.book.sort.Quick3way;

public class SuffixArray {
    private final String[] suffixes; // 后缀数组
    private final int N;             // 字符串的长度

    public SuffixArray(String s) {
        N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i);
        }
        new Quick3way().sort(suffixes);
    }

    public int length() {
        return N;
    }

    // 目标的字符串
    public String select(int i) {
        return suffixes[i];
    }

    // 查找目标所在的索引
    public int index(int i) {
        return N - suffixes[i].length();
    }

    // 找到两个字符串的最长子串
    private static int lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return N;
    }


    public int icp(int i) {
        return lcp(suffixes[i], suffixes[i - 1]);
    }

    public int rank(String key) {
        // 二分查找
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(suffixes[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}
