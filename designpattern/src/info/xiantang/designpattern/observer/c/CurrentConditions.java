package info.xiantang.designpattern.observer.c;

import java.util.ArrayList;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 17:47
 */
public class CurrentConditions implements Subject {
    private double current;
    private ArrayList<Observer> observers;

    public CurrentConditions(int current) {
        this.current = current;
        observers = new ArrayList<>();
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        double pre = this.current;
        this.current = current;
        if (Math.abs(pre - current) > Math.abs(pre * 0.05)) {
            notifyObservers();
        }

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o :
                observers) {
            o.response();

        }
    }
}
