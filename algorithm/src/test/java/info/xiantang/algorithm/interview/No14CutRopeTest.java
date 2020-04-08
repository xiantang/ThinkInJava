package info.xiantang.algorithm.interview;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class No14CutRopeTest {

    @Test
    public void testCutRopeRecursive() {
        int actual = No14CutRepo.cut(8);
        assertEquals(18, actual);
    }
}
