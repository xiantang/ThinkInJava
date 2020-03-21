package info.xiantang.designpattern.decorator.encrypt;

public class OtherAEncrypt extends EncryptDecorator {
    public OtherAEncrypt(EncryptComponent encryptComponent) {
        super(encryptComponent);
    }

    @Override
    String encrypt(String str) {
        return otherAEncrypt(super.encrypt(str));
    }
    public String otherAEncrypt(String str){
        System.out.println("对字符串 \'"+str+"\' 使用OtherA加密   =====>  OtherA加密结果");
        return "OtherA 加密结果";
    }

    public static void main(String[] args) {
        EncryptComponent originalEncrypt, otherAEncrypt, otherBEncrypt;
        String result;
        originalEncrypt = new OriginalEncrypt();
        result = originalEncrypt.encrypt("初始数据");
        System.out.println("-----------------------");
        otherAEncrypt = new OtherAEncrypt(originalEncrypt);
        result = otherAEncrypt.encrypt("初始数据");
        System.out.println("-----------------------");
        otherBEncrypt = new OtherBEncrypt(otherAEncrypt);
        result = otherBEncrypt.encrypt("初始数据");
    }
}


class OtherBEncrypt extends EncryptDecorator {
    public OtherBEncrypt(EncryptComponent encryptComponent) {
        super(encryptComponent);
    }

    @Override
    String encrypt(String str) {
        return otherAEncrypt(super.encrypt(str));
    }
    public String otherAEncrypt(String str){
        System.out.println("对字符串 \'"+str+"\' 使用OtherB加密   =====>  OtherB加密结果");
        return "OtherB 加密结果";
    }


}