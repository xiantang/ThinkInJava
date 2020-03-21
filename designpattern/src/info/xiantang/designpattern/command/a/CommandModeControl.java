package info.xiantang.designpattern.command.a;


/**
 * @Author: xiantang
 * @Date: 2019/5/7 15:50
 */
public class CommandModeControl implements Control {
    private Command[] onCommands;
    private Command[] offCommands;

    public CommandModeControl() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        Command noCommand = new NoCommand();
        for (int i = 0, len = onCommands.length; i < len; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        offCommands[slot] = offCommand;
        onCommands[slot] = onCommand;

    }
    @Override
    public void onButton(int slot) {
        onCommands[slot].execute();

    }

    @Override
    public void offButton(int slot){
        offCommands[slot].execute();
    }
}
