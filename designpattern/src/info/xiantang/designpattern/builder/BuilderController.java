package info.xiantang.designpattern.builder;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 20:45
 */
public class BuilderController {
    private Builder computerBuilder;

    public void setComputerBuilder(Builder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer constrat() {
        computerBuilder.buildCPU();
        computerBuilder.buildDisplay();
        computerBuilder.buildHardDisk();
        computerBuilder.buildMemory();
        return computerBuilder.getComputer();
    }

    public static void main(String[] args) {
        BuilderController bc = new BuilderController();
        bc.setComputerBuilder(
                new ComputerBuilder()
        );
        bc.constrat();
    }
}
