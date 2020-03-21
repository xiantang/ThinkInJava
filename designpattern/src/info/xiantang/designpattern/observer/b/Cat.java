package info.xiantang.designpattern.observer.b;

import java.util.ArrayList;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 17:36
 */
public class Cat implements Subject {
    private ArrayList<Observer> obsevers;

    @Override
    public void aimAt(Observer obs) {
        this.obsevers.add(obs);
    }

    public void cry() {
        System.out.println("cat cry!");
        for (Observer o :
                obsevers) {
            o.response();

        }
    }
    public Cat() {
        obsevers = new ArrayList<>();

    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        Mouse mouse = new Mouse("mouse1", cat);
        Master master = new Master(cat);
        cat.cry();
    }
}
