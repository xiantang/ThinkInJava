package info.xiantang.designpattern.strategy.type;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 18:23
 */
public class CaesarEncryption implements Encrypt {
    @Override
    public String encryptCode(String s) {
        return s + "1111";
    }
}
