package designpattern.facade;

public class Memory {
    private static Memory ourInstance = new Memory();

    public static Memory getInstance() {
        return ourInstance;
    }

    public void check() {
        System.out.println("Memory check!");
    }
    private Memory() {
    }
}
