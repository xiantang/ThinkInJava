package info.xiantang.designpattern.proxy.b;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 15:15
 */
public interface AbstractPermission {
    void modifyUserInfo();

    void viewNote();

    void publishNote();

    void modifyNote();

    void setLevel(int level);
}
