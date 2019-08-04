package designpattern.observer.a;

/**
 * @Author: xiantang
 * @Date: 2019/5/8 23:31
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}
