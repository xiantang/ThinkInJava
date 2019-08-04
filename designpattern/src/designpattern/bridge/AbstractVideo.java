package designpattern.bridge;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 15:51
 */
public abstract class AbstractVideo {
    protected VideoImp videoImp;

    public void setVideoImp(VideoImp videoImp) {
        this.videoImp = videoImp;
    }

    public abstract void parseFile(String fileName);
}
