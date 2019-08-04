package designpattern.proxy.a;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 15:08
 */
public class LoggerProxy implements AbstractLog {
    private CurrentBusinessClass currentBusinessClass = new CurrentBusinessClass();

    public void invorkMethodTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));

    }
    @Override
    public void method() {
        invorkMethodTime();
        currentBusinessClass.method();
        System.out.println("调用成功");
    }

    public static void main(String[] args) {
        new LoggerProxy().method();

    }
}
