package info.xiantang.designpattern.observer.b;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 17:29
 */
public class Mouse implements Observer {
    private String name;

    public Mouse(String name,Subject sub) {
        this.name = name;
        sub.aimAt(this);

    }

    @Override
    public void response() {
        System.out.println(name + " attempt to escape!");
    }
}
