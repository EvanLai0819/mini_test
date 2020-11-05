package mini.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import util.*;
import Exception.*;

import java.util.Arrays;
import java.util.ArrayList;
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
        Combination c = new Combination();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;

        assertEquals(expectedResult, combinationResult);
    }

    @Test
    public void testMultiCombination() {
        int[] testArr = {2, 3};
        List<String> expectedResult = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Combination c = new Combination();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;

        assertEquals(expectedResult, combinationResult);
    }


    @Test
    public void testSpecialCombination() {
        int[] testArr = {0,2,3};
        List<String> expectedResult = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Combination c = new Combination();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;

        assertEquals(expectedResult, combinationResult);
    }

    @Test
    public void testNotExsitValueCombination() {
        int[] testArr = {0,99};
        Combination c = new Combination();
        try{
            c.combinationCal(testArr);
        }catch(MiniException e){
            assertEquals(e.getErrorMsg(),"number is not match");
        }
    }

    @Test
    public void testEmptyCombination() {
        int[] testArr = {};
        Combination c = new Combination();
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
        Combination c = new Combination();
        c.setCacheStatus();
        c.combinationCal(testArr);
        List<String> combinationResult = c.combinationResult;
        List<String> cacheCombinationResult = c.cacheCombinationResult;

        assertEquals(cacheCombinationResult, combinationResult);
    }
}
