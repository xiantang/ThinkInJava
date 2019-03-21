package io;

import java.io.*;

public class BasicFileOutPut {
    static String file = "ThinkingInJava.out";

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("ThinkingInJava.iml")
                )
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file))
        );
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount+++": "+s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));



    }
}
