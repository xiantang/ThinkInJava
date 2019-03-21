package c10;

public class GFG {
    public static void main(String[] args) {
        Geek g1 = new Geek("aa", 1);
        Geek g2 = new Geek("aa", 1);
        if (g1.hashCode() == g2.hashCode()) {
            if (g1.hashCode() == g2.hashCode()) {
                System.out.println("Both Objects are equal. ");
            }
            else
                System.out.println("Both Objects are not equal.");
        }
        else
            System.out.println("Both Objects are not equal. ");
    }
}
