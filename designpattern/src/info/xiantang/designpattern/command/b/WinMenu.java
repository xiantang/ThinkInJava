package info.xiantang.designpattern.command.b;


import java.util.ArrayList;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 16:11
 */

class MenuItem {
    private Command command;
    private String itemName;
    public MenuItem(String itemName,Command command) {
        this.command = command;
        this.itemName = itemName;
    }
    public Command getCommand() {
        return command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void click(){
        System.out.println("MenuItem中的"+this.itemName+"被执行");
        this.command.excute();
    }
}
public class WinMenu implements Menu {
    private ArrayList<MenuItem> menuItemsList = new ArrayList<MenuItem>();
    @Override
    public void click(int slot) {
        menuItemsList.get(slot).click();
    }


    public void addMenuItem(MenuItem item) {

        menuItemsList.add(item);
    }
}
