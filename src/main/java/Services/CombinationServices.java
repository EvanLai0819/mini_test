package Services;

import Exception.MiniException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationServices {
    private HashMap<Integer, String> numberConfig;
    public List<String> combinationResult = new ArrayList<>();
    public List<String> cacheCombinationResult = new ArrayList<>();
    public int cache = 0;

    /**
     * verify input correct or not, if not, it will throw exception
     * @param input
     */
    private void validation(int[] input) {
        if (input.length == 0) {
            throw new MiniException("100001", "empty input");
        }

        int length = 0;
        length = input.length;
        String numberConfigValue = "";
        for (int inputIndex = 0; inputIndex < length; inputIndex++) {
            numberConfigValue = this.numberConfig.get(input[inputIndex]);
            if (numberConfigValue == null) {
                throw new MiniException("100002", "number is not match");
            }
        }
    }

    /**
     * get default digital letter table
     */
    private void getNumberConf() {
        this.numberConfig = new HashMap<Integer, String>();
        numberConfig.put(0, "");
        numberConfig.put(1, "");
        numberConfig.put(2, "abc");
        numberConfig.put(3, "def");
        numberConfig.put(4, "ghi");
        numberConfig.put(5, "jkl");
        numberConfig.put(6, "mno");
        numberConfig.put(7, "pqrs");
        numberConfig.put(8, "tuv");
        numberConfig.put(9, "wxyz");
    }

    /**
     * combination input
     * @param input
     */
    public void combinationCal(int[] input) {
        //1. get the default letter table
        this.getNumberConf();
        //2. check the input correct or not
        this.validation(input);
        int length = 0;
        length = input.length;
        String numberConfigValue = "";
        char[] numberConfigArr;
        //if set cache equal true and cache has exist, return cache
        if (this.getCacheStatus() == 1 && this.getCache().size() > 0) {
            this.combinationResult = this.cacheCombinationResult;
            return;
        }
        for (int inputIndex = 0; inputIndex < length; inputIndex++) {
            numberConfigValue = this.numberConfig.get(input[inputIndex]);
            if (inputIndex == 0 || this.combinationResult.size() == 0) {
                numberConfigArr = numberConfigValue.toCharArray();
                for (int numberConfigArrIndex = 0; numberConfigArrIndex < numberConfigArr.length; numberConfigArrIndex++) {
                    this.combinationResult.add(Character.toString(numberConfigArr[numberConfigArrIndex]));
                }
                continue;
            } else {
                numberConfigArr = numberConfigValue.toCharArray();
                List<String> tmp_queue = new ArrayList<>();
                for (String item : this.combinationResult) {
                    for (int numberConfigArrIndex = 0; numberConfigArrIndex < numberConfigArr.length; numberConfigArrIndex++) {
                        tmp_queue.add(item + Character.toString(numberConfigArr[numberConfigArrIndex]));
                    }
                    this.combinationResult = tmp_queue;
                }
            }
        }

        if (this.getCacheStatus() == 1) {
            this.cacheCombinationResult = this.combinationResult;
        }
        System.out.println("result is " + this.combinationResult);
    }

    /**
     * set use cache or not,if use it, it can imporve performance
     */
    public void setCacheStatus() {
        this.cache = 1;
    }

    /**
     * get cache status
     * @return
     */
    public Integer getCacheStatus() {
        return this.cache;
    }

    /**
     * get cache data
     * @return
     */
    public List<String> getCache() {
        return this.cacheCombinationResult;
    }
}
