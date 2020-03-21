package info.xiantang.designpattern.strategy.type;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 18:20
 */
public class EncraptMS {

    private Encrypt encrypt;

    public EncraptMS(Encrypt encrypt) {
        this.encrypt = encrypt;
    }

    public String encryptCode(String s) {
        return encrypt.encryptCode(s);
    }

    public static void main(String[] args) {
        EncraptMS encraptMS = new EncraptMS(new CaesarEncryption());
        String a = encraptMS.encryptCode("aaaaa");
        System.out.println(a);
    }
}
