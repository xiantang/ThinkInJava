package designpattern.facade;

public class Disk {
    private static Disk ourInstance = new Disk();

    public static Disk getInstance() {
        return ourInstance;
    }
    public void read() {
        System.out.println("Disk read()");
    }
    private Disk() {
    }
}
