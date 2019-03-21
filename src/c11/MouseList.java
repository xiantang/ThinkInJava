package c11;

import java.util.ArrayList;
import java.util.List;

public class MouseList {
    private List list = new ArrayList();
    public void  add(Mouse m) {
        list.add(m);
    }
    public Mouse get(int index) {
        return (Mouse) list.get(index);
    }
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MouseList mice = new MouseList();
        for (int i = 0; i <3 ; i++) {
            mice.add(new Mouse(i));
        }
        for (int i = 0; i <mice.size() ; i++) {
            MouseTrap.caughtYa(mice.get(i));
        }
    }
}
