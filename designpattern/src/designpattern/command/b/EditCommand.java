package designpattern.command.b;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 16:23
 */
public class EditCommand implements Command {
    private BoardScreen  BoardScreen;

    @Override
    public void excute() {
        BoardScreen.edit();
    }

    public EditCommand(BoardScreen boardScreen) {
        this.BoardScreen = boardScreen;
    }

}

class OpenCommand  implements Command {
    private BoardScreen  BoardScreen;

    @Override
    public void excute() {
        BoardScreen.open();
    }

    public OpenCommand(BoardScreen boardScreen) {
        this.BoardScreen = boardScreen;
    }

}

