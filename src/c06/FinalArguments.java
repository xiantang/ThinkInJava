package c06;

public class FinalArguments {
    void with(final Gizmo gizmo) {
        // 无法更改引用
    }

    void without(Gizmo gizmo) {
        gizmo = new Gizmo();
        gizmo.spin();
    }

    int g(final int i) {
        // 只读
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);

    }
}
