package info.xiantang.designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 15:56
 */
public class UNIXImp implements VideoImp {
    @Override
    public void doPlay() {
        System.out.println("UNIX!");
    }
}
