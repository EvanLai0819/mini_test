package util;

import Exception.MiniException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combination {
    private HashMap<Integer, String> numberConfig;
    public List<String> queue = new ArrayList<>();
    public List<String> cacheQueue = new ArrayList<>();
    public int cache = 0;

    private void validation(int[] input) {
        if (input.length == 0) {
            System.out.println("ERROR: empty input -> " + input);
            throw new MiniException("500", "empty input");
        }

        int length = 0;
        length = input.length;
        String str = "";
        for (int inputIndex = 0; inputIndex < length; inputIndex++) {
            str = this.numberConfig.get(input[inputIndex]);
            if (str == null) {
                throw new MiniException("500", "str no exist");
            }
        }
    }

    /**
     * return array
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

    public void combinationCal(int[] input) {
        this.getNumberConf();
        this.validation(input);
        int length = 0;
        length = input.length;
        String str = "";
        char[] numberConfigArr;
        for (int inputIndex = 0; inputIndex < length; inputIndex++) {
            str = this.numberConfig.get(input[inputIndex]);
            if(str=='') continue;
            if (inputIndex == 0) {
                numberConfigArr = str.toCharArray();
                for (int numberConfigArrIndex = 0; numberConfigArrIndex < numberConfigArr.length; numberConfigArrIndex++) {
                    this.queue.add(Character.toString(numberConfigArr[numberConfigArrIndex]));
                }
                continue;
            } else {
                numberConfigArr = str.toCharArray();
                List<String> tmp_queue = new ArrayList<>();
                for (String queueItem : this.queue) {
                    // this.queue.remove(qi);
                    for (int numberConfigArrIndex = 0; numberConfigArrIndex < numberConfigArr.length; numberConfigArrIndex++) {
                        tmp_queue.add(queueItem + Character.toString(numberConfigArr[numberConfigArrIndex]));
                    }
                    this.queue = tmp_queue;
                }
            }
        }

        if (this.getCache() == 1) {
            this.cacheQueue = this.queue;
        }
        System.out.println("result is " + this.queue);
    }

    public void setCacheStatus() {
        this.cache = 1;
    }

    public Integer getCache() {
        return this.cache;
    }
}
