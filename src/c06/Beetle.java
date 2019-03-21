package c06;

class Insert{
    private int i = 9;
    protected int j;

    public Insert() {
        System.out.println("i = " + i + ",j =" + j);
        j = 39;
    }

    private static int x = print("static Insect.x1 initialized");

    static int print(String s) {
        System.out.println(s);
        return 47;
    }

}
public class Beetle extends Insert{
    private int k = print("Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 = print("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
