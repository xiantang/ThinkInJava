package c11;

import java.util.ArrayList;
import java.util.List;

public class WorksAnyway {
    public static void main(String[] args) {
        List mice = new ArrayList();
        for (int i = 0; i <3 ; i++) {
            mice.add(new Mouse(i));
        }
        for (int i = 0; i < mice.size(); i++) {
            System.out.println("Free mouse: " + mice.get(i));
            MouseTrap.caughtYa(mice.get(i));
        }

    }
}
