package info.xiantang.designpattern.proxy.b;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 15:17
 */
public class RealPermission implements AbstractPermission {
    @Override
    public void modifyUserInfo() {
        System.out.println("modifyUserInfo");
    }

    @Override
    public void viewNote() {
        System.out.println("viewNote");
    }

    @Override
    public void publishNote() {
        System.out.println("publishNote");
    }

    @Override
    public void modifyNote() {
        System.out.println("modifyNote");
    }

    @Override
    public void setLevel(int level) {

    }
}
