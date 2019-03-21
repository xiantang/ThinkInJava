package generics;

public class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }
    void manipulator() {
        obj.f();
    }

    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator =
                new Manipulator<>(hf);
        manipulator.manipulator();
    }
}
