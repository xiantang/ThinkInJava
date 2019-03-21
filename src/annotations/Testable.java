package annotations;

import EnumClass.Test;

public class Testable {
    public void execuute() {
        System.out.println("Executing");
    }

    @Test
    public void testExecute() {
        execuute();
    }

    public static void main(String[] args) {
        System.out.println(1);
    }

}
