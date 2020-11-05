package mini.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import util.*;

import java.util.List;

public class CalculateTest extends TestCase {
    @Before
    public void setUp() {
    }

    @After
    public void after() {
    }

    @Test
    public void testSingleCombination() {
        int[] str = {2};
        String[] expectedResult = {"a","b","c"};
        Combination c = new Combination();
        c.setCacheStatus();
        c.combinationCal(str);
        List<String> queue = c.queue;

        assertEquals(expectedResult, queue);
    }

    @Test
    public void testMultiCombination() {
        int[] str = {2, 3};
        String[] expectedResult = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        Combination c = new Combination();
        c.setCacheStatus();
        c.combinationCal(str);
        List<String> queue = c.queue;

        assertEquals(expectedResult, queue);
    }

    @Test
    public void testEmptyCombination() {
        int[] str = {};
        String[] expectedResult = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        Combination c = new Combination();
        c.setCacheStatus();
        c.combinationCal(str);
        List<String> queue = c.queue;

        assertEquals(expectedResult, queue);
    }
}
