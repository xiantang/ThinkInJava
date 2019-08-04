package designpattern.adopter.b;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 11:25
 */
public interface Encryption {
    /**
     * 加密方法
     */
    public String encode(String string);

    /**
     * 解密方法
     */
    public String decode(String string);
}
