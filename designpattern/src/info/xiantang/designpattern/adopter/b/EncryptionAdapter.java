package info.xiantang.designpattern.adopter.b;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 11:27
 */
public class EncryptionAdapter implements Encryption {
    private ThirdPartyEncryption tpe;

    public EncryptionAdapter() {
        tpe = new ThirdPartyEncryption();
    }

    @Override
    public String encode(String string) {
        // 调用第三方的加密方法
        return tpe.tEncode(string);
    }

    @Override
    public String decode(String string) {
        // 调用第三方的解密方法
        return tpe.tDecode(string);
    }

}
