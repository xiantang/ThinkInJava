package concurrency.AtomicVariablesAndNonblockingSynchronization;

/**
 * @Author: xiantang
 * @Date: 2019/4/27 19:25
 */
public class CasCounter {
    private SimulatedCAS value = new SimulatedCAS();

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }

    public static void main(String[] args) {
        System.out.println(new CasCounter().increment());
    }
}
