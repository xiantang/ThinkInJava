package concurrency;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public synchronized static int nextSerialNumber() {
        // 不是原子操作
        return serialNumber++;
    }
}
