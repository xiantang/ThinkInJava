package info.xiantang.designpattern.factory;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 19:18
 */
public class TCLFactory implements Factory {
    @Override
    public TV createTV() {
        return new TCLTV();
    }

    @Override
    public AirConditioner createConditioner() {
        return new TCLAirConditioner();
    }

}
