package designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 16:01
 */
public class WMVVideo extends  AbstractVideo {
    @Override
    public void parseFile(String fileName) {
        System.out.println("WMVVideo play " + fileName);
        videoImp.doPlay();
    }
}
