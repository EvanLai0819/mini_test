package mini.test;

import util.*;

public class Calculate {
    public static void main(String[] args) {
        //stage 1 covert digital 0 - 9 to letter
        int[] str = {0,2,3};
        Combination c = new Combination();
        c.combinationCal(str);

        //stage 2 covert digital 0 - 99 to letter
        int[] str = {33,99};
        Combination c = new Combination();
        c.setCacheStatus();
        c.combinationCal(str);
    }
}
