package ThreadSafety;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class OneValueCache {
    // 因为是不可变的
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactory;

    public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactory) {
        this.lastNumber = lastNumber;
        this.lastFactory = Arrays.copyOf(lastFactory, lastFactory.length);
    }

    public BigInteger[] getLastFactory(BigInteger integer) {
        if (lastNumber == null || !lastNumber.equals(integer)) {
            return null;
        } else return Arrays.copyOf(lastFactory, lastFactory.length);
    }
}
