package info.xiantang.algorithm.interview;

class No2TwiceCheckSingleton {
    private volatile static No2TwiceCheckSingleton instance = null;
    private static final Object sybObj = new Object();

    private No2TwiceCheckSingleton() {
    }

    static No2TwiceCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (sybObj) {
                if (instance == null) {
                    instance = new No2TwiceCheckSingleton();
                }
            }
        }

        return instance;
    }
}
