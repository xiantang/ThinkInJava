package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class PasswordUtils {
//    @Deprecated // 遗弃的api意思
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassWord(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49,description = "New passwords can't equal previous used ones")
    public boolean checkForPassword(List<String> prevPassword ,String password) {
//        return new StringBuilder(password).reverse().toString();
        return !prevPassword.contains(password);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        new PasswordUtils().validatePassword("dasdasd");
        Method[] method = new PasswordUtils().getClass().getMethods();
        Method methods = method[1];
        Annotation a = methods.getAnnotation(UseCase.class);
        System.out.println(((UseCase) a).id());
    }
}
