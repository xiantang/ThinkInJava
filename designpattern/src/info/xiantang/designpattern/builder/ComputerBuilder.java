package info.xiantang.designpattern.builder;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 20:43
 */
public class ComputerBuilder extends Builder {
    @Override
    public void buildCPU() {
        getComputer().setCpu("cpu");
    }

    @Override
    public void buildMemory() {
        getComputer().setMemory("memory");
    }

    @Override
    public void buildHardDisk() {
        getComputer().setMemory("hardDisk");
    }

    @Override
    public void buildHost() {
        getComputer().setHost("host");
    }

    @Override
    public void buildDisplay() {
        getComputer().setDisplay("display");
    }
}
