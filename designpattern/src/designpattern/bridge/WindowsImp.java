package designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 15:55
 */
public class WindowsImp implements VideoImp {
    @Override
    public void doPlay() {
        System.out.println("windows !");
    }
}
