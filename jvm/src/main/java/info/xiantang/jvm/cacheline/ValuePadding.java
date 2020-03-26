package info.xiantang.jvm.cacheline;

import sun.misc.Contended;

public class ValuePadding {

    @Contended
    protected volatile long value = 0L;
}
