package info.xiantang.designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 15:57
 */
public class MPEGVideo extends AbstractVideo {
    @Override
    public void parseFile(String fileName) {
        System.out.println("MPEGVideo play " + fileName);
        videoImp.doPlay();
    }
}
