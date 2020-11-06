package mini_code;

import Services.CombinationServices;

public class Calculate {
    public static void main(String[] args) {
        //stage 1 covert digital 0 - 9 to letter
        int[] str = {0,2,3};
        CombinationServices singleCombiation = new CombinationServices();
        singleCombiation.combinationCal(str);

        //stage 2 covert digital 0 - 99 to letter
        int[] strMulti = {33,99};
        CombinationServices multiCombiation = new CombinationServices();
        multiCombiation.setCacheStatus();
        multiCombiation.combinationCal(strMulti);
    }
}
