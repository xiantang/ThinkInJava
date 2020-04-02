package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No2TwiceCheckSingletonTest {

    @Test
    public void testTwiceCheckSingleton() {
        No2TwiceCheckSingleton singleton1 = No2TwiceCheckSingleton.getInstance();
        No2TwiceCheckSingleton singleton2 = No2TwiceCheckSingleton.getInstance();
        assertEquals(singleton1, singleton2);
    }

}
