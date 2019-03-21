package c06;

import java.util.Stack;
import java.util.Vector;

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // 你可以向上转型
        OverridingPrivate op = op2;
        WithFinals wf = op2;

    }
}
