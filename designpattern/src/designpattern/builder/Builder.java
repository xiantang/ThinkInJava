package designpattern.builder;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 20:36
 */
public abstract class Builder {
    private Computer computer = new Computer();

    public abstract void buildCPU();

    public abstract void buildMemory();

    public abstract void buildHardDisk();

    public abstract void buildHost();

    public abstract void buildDisplay();
    public Computer getComputer() {
        return computer;
    }
}
