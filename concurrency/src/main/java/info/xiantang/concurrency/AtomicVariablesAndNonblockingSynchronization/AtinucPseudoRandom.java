package info.xiantang.concurrency.AtomicVariablesAndNonblockingSynchronization;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xiantang
 * @Date: 2019/4/27 19:47
 */
public class AtinucPseudoRandom  {
    private AtomicInteger seed;

    public AtinucPseudoRandom(int seed) {
        this.seed = new AtomicInteger(seed);
    }

    public int nextInt(int n) {
        while (true) {
            int s = seed.get();
//            int nextSeed =
        }
    }


}
