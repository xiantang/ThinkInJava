package c07;

public class Hide {
    private static RandomShapeGenerator gen =
            new RandomShapeGenerator();
    public static void main(String[] args) {
//        Bart b = new Bart();
//        b.doh(1);
//        b.doh('x');
//        b.doh(1.0f);
//        b.doh(new Milhouse());
        Shape[] s = new Shape[9];
        for(int i = 0; i < s.length; i++)
            s[i] = gen.next();
        for (int i = 0; i < s.length; i++) {
            s[i].draw();
        }
    }
}
