package mini.test;

import static org.junit.Assert.assertTrue;

import Services.CombinationServices;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import Exception.*;

import java.util.Arrays;
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
        int[] testArr = {2};
        List<String> expectedResult = Arrays.asList("a","b","c");
        CombinationServices c = new CombinationServices();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;

        assertEquals(expectedResult, combinationResult);
    }

    @Test
    public void testMultiCombination() {
        int[] testArr = {2, 3};
        List<String> expectedResult = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        CombinationServices c = new CombinationServices();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;

        assertEquals(expectedResult, combinationResult);
    }


    @Test
    public void testSpecialCombination() {
        int[] testArr = {0,2,3};
        List<String> expectedResult = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        CombinationServices c = new CombinationServices();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;

        assertEquals(expectedResult, combinationResult);
    }

    @Test
    public void testNotExsitValueCombination() {
        int[] testArr = {0,99};
        CombinationServices c = new CombinationServices();
        try{
            c.combinationCal(testArr);
        }catch(MiniException e){
            assertEquals(e.getErrorMsg(),"number is not match");
        }
    }

    @Test
    public void testEmptyCombination() {
        int[] testArr = {};
        CombinationServices c = new CombinationServices();
        c.setCacheStatus();
        try{
            c.combinationCal(testArr);
        }catch(MiniException e){
            assertEquals(e.getErrorMsg(),"empty input");
        }
    }

    @Test
    public void testCacheCombination() {
        int[] testArr = {0,2,3};
        CombinationServices c = new CombinationServices();
        c.setCacheStatus();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;
        List<String> cacheCombinationResult = c.cacheCombinationResult;

        assertEquals(cacheCombinationResult, combinationResult);
    }
}
