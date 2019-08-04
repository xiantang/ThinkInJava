package designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 16:00
 */
public class AVIVideo extends AbstractVideo {
    @Override
    public void parseFile(String fileName) {
        System.out.println("AVIVideo play " + fileName);
        videoImp.doPlay();
    }
}