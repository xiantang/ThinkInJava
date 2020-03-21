package info.xiantang.designpattern.decorator.encrypt;

public class EncryptDecorator extends EncryptComponent {
    EncryptComponent encryptComponent;

    public EncryptDecorator(EncryptComponent encryptComponent) {
        this.encryptComponent = encryptComponent;
    }

    @Override
    String encrypt(String str) {
        return encryptComponent.encrypt(str);
    }
}
