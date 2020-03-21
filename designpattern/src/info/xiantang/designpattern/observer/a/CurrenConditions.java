package info.xiantang.designpattern.observer.a;

/**
 * @Author: xiantang
 * @Date: 2019/5/10 21:41
 */
public class CurrenConditions implements Observer {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    @Override
    public void update(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();

    }

    public void display() {
        System.out.println(mHumidity + " " + mPressure + " "+mTemperature);
    }
}
