package designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 15:55
 */
public class LinuxImp implements VideoImp {
    @Override
    public void doPlay() {
        System.out.println("Linux!");
    }
}
