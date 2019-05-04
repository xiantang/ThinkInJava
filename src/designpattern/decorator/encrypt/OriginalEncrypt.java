package designpattern.decorator.encrypt;

public class OriginalEncrypt extends EncryptComponent {
    @Override
    String encrypt(String str) {
        System.out.println("对字符串 \'" + str + "\' 使用原始加密   =====>  原始加密结果");
        return "原始加密结果";
    }
}
