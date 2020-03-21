package info.xiantang.designpattern.proxy.b;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 15:18
 */
public class PermissionProxy implements AbstractPermission {
    private RealPermission permission = new RealPermission();
    private int level = 0;

    public PermissionProxy() {
        permission.setLevel(0);
    }

    @Override
    public void modifyUserInfo() {
        permission.modifyUserInfo();
    }

    @Override
    public void viewNote() {
        permission.viewNote();
    }

    @Override
    public void publishNote() {
        permission.publishNote();
    }

    @Override
    public void modifyNote() {
        permission.modifyNote();
    }

    @Override
    public void setLevel(int level) {
        permission.setLevel(level);

    }
}
