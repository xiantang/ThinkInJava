package designpattern.facade;

public class Host {
    private static Host ourInstance = new Host();

    public static Host getInstance() {
        return ourInstance;
    }

    private Host() {
    }

    public void on() {
        System.out.println("Host on!");
    }

    public void method() {
    }
}
