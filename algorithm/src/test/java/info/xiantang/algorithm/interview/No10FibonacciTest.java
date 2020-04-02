package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No10FibonacciTest {

    @Test
    public void testFibonacci() {
        int actual = No10Fibonacci.fibonacciRecursive(7);
        assertEquals(13, actual);
        int actual1 = No10Fibonacci.fibonacciIteration(7);
        assertEquals(13, actual1);
    }


}
