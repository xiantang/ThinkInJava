package info.xiantang.limiter;

class FunnelRateLimiter {


    private final int capacity;
    private final double leakingRate;
    private int emptyCapacity;
    private long lastLeakingTime = System.currentTimeMillis();


    FunnelRateLimiter(int capacity, double leakingRate) {
        this.capacity = capacity;
        this.leakingRate = leakingRate;
        this.emptyCapacity = capacity;
    }

    private void makeSpace() {
        long currentTimeMillis = System.currentTimeMillis();
        long gap = currentTimeMillis - lastLeakingTime;
        double deltaQuota = (int) gap * leakingRate;
        lastLeakingTime = currentTimeMillis;
        if (deltaQuota < 0) {
            emptyCapacity = capacity;
        }
        emptyCapacity += deltaQuota;
        if (emptyCapacity > capacity) {
            emptyCapacity = capacity;
        }

    }

    boolean isActionAllowed(int quota) {
        makeSpace();
        if (emptyCapacity >= quota) {
            emptyCapacity -= quota;
            return true;
        }
        return false;
    }
}
