package info.xiantang.concurrency.design.c4.feature;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 15:48
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                System.out.println("sleep " + i);
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        result = sb.toString();
    }

    public String getResult() {
        return result;
    }
}
