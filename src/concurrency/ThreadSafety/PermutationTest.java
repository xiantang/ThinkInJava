package concurrency.ThreadSafety;


import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PermutationTest {
    Permutation permutation = new Permutation();

    @Test
    public void testEqual() {
        List<String> listS = ArrangementUtil.getFullArrangement("qwert".toCharArray());
        List<String> listT = ArrangementUtil.getFullArrangement("trewq".toCharArray());
        for (String s : listS) {
            for (String t : listT) {
                assertTrue(permutation.equal(s, t));
            }
        }

    }

    @Test
    public void testEmptyStringEqual() {
        assertTrue(permutation.equal("", ""));

    }

    @Test
    public void testDifferentLengthsStringEqual() {
        List<String> listS = ArrangementUtil.getFullArrangement("qwer".toCharArray());
        List<String> listT = ArrangementUtil.getFullArrangement("trewq".toCharArray());
        for (String s : listS) {
            for (String t : listT) {
                assertFalse(permutation.equal(s, t));
            }
        }
    }

}
