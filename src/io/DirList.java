package io;

import java.io.File;
import java.util.Arrays;

public class DirList {
    public static void main(String[] args) {
        File path = new File("./src");

        String[] list;
        if (args.length == 0) {
            // list 回调
            list = path.list();
        }
        else
            // DirFilter 提供了策略的形式
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem: list
             ) {
            System.out.println(dirItem);
        }
    }
}
