package mini.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import util.*;

import java.util.List;

public class CalTest extends TestCase {
    @Before
    public void setUp() {
    }

    @After
    public void after() {
    }

    @Test
    public void testCombination() {
        int[] str = {2, 3};
        String[] expectedResult = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        Combition c = new Combition();
        c.setCache();
        c.combineCal(str);
        List<String> queue = c.queue;

        assertEquals(expectedResult, queue);
    }
}
