package designpattern.observer.a;

import java.util.ArrayList;

/**
 * @Author: xiantang
 * @Date: 2019/5/10 21:46
 */
public class WeatherDataSt implements Subject {

    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;

    private ArrayList<Observer> observers;

    public void update(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperatrue = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();

    }

    private void dataChange() {

    }


    public WeatherDataSt() {
        observers = new ArrayList<>();
    }

    public float getmTemperatrue() {
        return mTemperatrue;
    }

    public void setmTemperatrue(float mTemperatrue) {
        this.mTemperatrue = mTemperatrue;
    }

    public float getmPressure() {
        return mPressure;
    }

    public void setmPressure(float mPressure) {
        this.mPressure = mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity(float mHumidity) {
        this.mHumidity = mHumidity;
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob :
                observers) {
            ob.update(getmTemperatrue(), getmPressure(), getmHumidity());
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
}
