package designpattern.command.a;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 15:44
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {

    }
}
