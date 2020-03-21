package info.xiantang.designpattern.strategy.type;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 18:23
 */
public class ModularEncryption implements Encrypt {
    @Override
    public String encryptCode(String s) {
        return s + "2222";
    }
}
