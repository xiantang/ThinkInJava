package info.xiantang.concurrency.ComposingObjects;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberRange {
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // 先检查 X
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't" + i);
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't " + i);
        }
        upper.set(i);
    }

    public boolean isInRange(int i
    ) {
        return (i >= lower.get() && i <= upper.get());
    }

}
