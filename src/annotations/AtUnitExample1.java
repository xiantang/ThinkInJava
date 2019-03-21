package annotations;

import org.junit.Test;

public class AtUnitExample1 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {

        System.out.println("This is methodTwo");;
        return 2;
    }

    @Test
   public boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }
//
//    @Test
//    boolean
}
