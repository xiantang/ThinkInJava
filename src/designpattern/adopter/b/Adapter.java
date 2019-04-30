package designpattern.adopter.b;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 11:27
 */
public class Adapter extends ThirdPartyEncryption implements Encryption {

    @Override
    public String encode(String string) {
        return tEncode(string);
    }

    @Override
    public String decode(String string) {
        return tDecode(string);
    }


}
