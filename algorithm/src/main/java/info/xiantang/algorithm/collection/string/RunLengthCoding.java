package info.xiantang.algorithm.collection.string;

import info.xiantang.algorithm.collection.algs4.BinaryStdIn;
import info.xiantang.algorithm.collection.algs4.BinaryStdOut;


public class RunLengthCoding {
    public static void expend() {
        boolean b = false;
        while (!BinaryStdIn.isEmpty()) {
            char cnt = BinaryStdIn.readChar();
            for (int i = 0; i < cnt; i++) {
                BinaryStdOut.write(b);
            }
            b = !b; // 转变值
        }

    }

    public static void compress() {
        char cnt = 0;
        boolean b, old = false;
        while (!BinaryStdIn.isEmpty()) {
            // 读取一位
            b = BinaryStdIn.readBoolean();
            if (b != old) {
                BinaryStdOut.write(cnt);
                cnt = 0;
                old = !old;
            }else {
                if (cnt == 255){
                    BinaryStdOut.write(cnt);
                    cnt = 0;
                    BinaryStdOut.write(cnt);
                }
            }
            cnt++;
        }
        BinaryStdOut.write(cnt);
        BinaryStdOut.close();
    }
}
