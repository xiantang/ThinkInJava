package info.xiantang.designpattern.observer.c;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 17:52
 */
public class Person implements Observer {
    @Override
    public void response() {
        System.out.println("aaaaa");

    }

    public static void main(String[] args) {
        Subject subject = new CurrentConditions(100);
        Observer person = new Person();
        subject.registerObserver(person);
        ((CurrentConditions) subject).setCurrent(200);

    }
}
