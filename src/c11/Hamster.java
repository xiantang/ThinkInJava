package c11;

import java.util.ArrayList;
import java.util.List;

public class Hamster {
    private int hamsterNumber;

    public Hamster(int hamsterNumber) {
        this.hamsterNumber = hamsterNumber;
    }

    @Override
    public String toString() {
        return "This is Hamster #" + hamsterNumber;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i <3 ; i++) {
            list.add(new Hamster(i));
        }
        Printer.printAll(list.iterator());
    }
}
