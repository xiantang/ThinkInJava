package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No5ReplaceSpaceTest {

    @Test
    public void replaceSpaceTest() {
        String s = "We are happy.";
        String result = No6ReplaceSpace.replace(s);
        String expect = "We%20are%20happy.";
        assertEquals(expect, result);
    }
}
