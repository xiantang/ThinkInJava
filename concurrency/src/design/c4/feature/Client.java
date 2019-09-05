package design.c4.feature;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 15:53
 */
public class Client {
    public Data request(final String queryStr) {
        final FutureData feature = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                feature.setRealData(realData);
            }
        }.start();
        return feature;
    }

    public static void main(String[] args) {
        Client client = new Client();
        // 这里会立刻返回
        Data data = client.request("name");
        System.out.println("请求完毕");
        System.out.println("数据 = " + data.getResult());
    }
}
