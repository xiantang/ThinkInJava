package info.xiantang.designpattern.command.a;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 16:00
 */
public class Client {
    public static void main(String[] args) {
        Command command = new LightOnCommand(new Light());
        CommandModeControl control = new CommandModeControl();
        control.setCommand(1, command, command);
        control.onButton(1);
    }
}
