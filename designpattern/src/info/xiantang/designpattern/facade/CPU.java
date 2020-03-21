package info.xiantang.designpattern.facade;

public class CPU {
    private static CPU ourInstance = new CPU();

    public static CPU getInstance() {
        return ourInstance;
    }

    public void run() {
        System.out.println("CPU run!");
    }

    private CPU() {
    }
}
