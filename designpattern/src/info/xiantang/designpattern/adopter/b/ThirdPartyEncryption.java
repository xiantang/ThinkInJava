package info.xiantang.designpattern.adopter.b;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 11:26
 */
public class ThirdPartyEncryption {
    public String tEncode(String string) {
        return "加密之后的" + string;
    }


    public String tDecode(String string) {
        return "解密之后的" + string;
    }
}
