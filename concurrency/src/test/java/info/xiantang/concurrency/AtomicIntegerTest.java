package info.xiantang.concurrency;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class AtomicIntegerTest {

    @Test
    public void testAddAndGet() {
        AtomicInteger atomicInteger = new AtomicInteger(40);
        atomicInteger.incrementAndGet();
        int i = atomicInteger.get();
        assertEquals(41, i);
    }





}
