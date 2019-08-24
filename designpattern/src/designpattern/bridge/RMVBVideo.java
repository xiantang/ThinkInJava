package designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 15:59
 */
public class RMVBVideo extends AbstractVideo {
    @Override
    public void parseFile(String fileName) {
        System.out.println("RMVBVideo play " + fileName);
        videoImp.doPlay();
    }
}
