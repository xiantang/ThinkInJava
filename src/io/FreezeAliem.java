package io;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAliem {
    public static void main(String[] args) throws Exception{
        ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream("X.file")
        );
        Aline quellek = new Aline();
        out.writeObject(quellek);

    }
}
