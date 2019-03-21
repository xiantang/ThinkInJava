package c11;

public class MouseTrap {
    static void caughtYa(Object m) {
        Mouse mouse = (Mouse) m;
        System.out.println("Mouse: " + mouse.getNumer());
    }
}
