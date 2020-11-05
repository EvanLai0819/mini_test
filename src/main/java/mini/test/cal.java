package mini.test;

import util.*;

public class cal {
    public static void main(String[] args) {
        int[] str = {2, 3};
        // int[] str = {2, 3,99,33};
        Combition c = new Combition();
        c.setCache();
        c.combineCal(str);
    }
}
