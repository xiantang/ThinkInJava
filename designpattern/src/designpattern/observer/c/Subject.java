package designpattern.observer.c;

/**
 * @Author: xiantang
 * @Date: 2019/5/11 17:46
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
