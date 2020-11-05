package mini.test;

import util.*;

public class Calculate {
    public static void main(String[] args) {
        int[] str = {2, 3};
        // int[] str = {2, 3,99,33};
        Combination c = new Combination();
        c.setCacheStatus();
        c.combinationCal(str);
    }
}
