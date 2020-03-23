package info.xiantang.concurrency.design.c4.feature;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 15:48
 */
public class FutureData implements Data {
    public RealData realData;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.result;
    }
}
