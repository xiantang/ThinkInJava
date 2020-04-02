package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No9UseTwoStackImpQueueTest {
    @Test
    public void testTwoStackImplQueue() {
        N9Queue<String> queue = new N9Queue<>();
        queue.appendTail("1");
        queue.appendTail("2");
        queue.appendTail("3");
        queue.appendTail("4");
        String first = queue.deleteHead();
        String second = queue.deleteHead();
        assertEquals("1", first);
        assertEquals("2", second);
    }
}
