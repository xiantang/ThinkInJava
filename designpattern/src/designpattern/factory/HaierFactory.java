package designpattern.factory;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 19:17
 */
public class HaierFactory implements Factory {

    @Override
    public TV createTV() {
        return new HaierTV();
    }

    @Override
    public AirConditioner createConditioner() {
        return new HaierAirConditioner();
    }

}
