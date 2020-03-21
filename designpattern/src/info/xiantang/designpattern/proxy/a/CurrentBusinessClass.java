package info.xiantang.designpattern.proxy.a;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 15:07
 */
public class CurrentBusinessClass implements AbstractLog {
    @Override
    public void method() {
        System.out.println("被调用");
    }
}
