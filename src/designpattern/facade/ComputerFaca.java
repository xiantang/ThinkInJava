package designpattern.facade;

public class ComputerFaca {
    private CPU cpu;
    private Disk disk;
    private Host host;
    private Memory memory;

    public ComputerFaca() {
        cpu = CPU.getInstance();
        disk = Disk.getInstance();
        host = Host.getInstance();
        memory = Memory.getInstance();
    }

    public void start() {
        host.on();
        cpu.run();
        disk.read();
        memory.check();
    }
}
