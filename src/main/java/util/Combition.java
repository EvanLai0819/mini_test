package util;

import Exception.MiniException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combition {
    private HashMap<Integer, String> hMap;
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
        for (int i = 0; i < length; i++) {
            str = this.hMap.get(input[i]);
            if (str == null) {
                throw new MiniException("500", "str no exist");
            }
        }
    }

    /**
     * return array
     */
    private void numberConf() {
        this.hMap = new HashMap<Integer, String>();
        hMap.put(2, "abc");
        hMap.put(3, "def");
        hMap.put(4, "ghi");
        hMap.put(5, "jkl");
        hMap.put(6, "mno");
        hMap.put(7, "pqrs");
        hMap.put(8, "tuv");
        hMap.put(9, "wxyz");
    }

    public void combineCal(int[] input) {
        this.numberConf();
        this.validation(input);
        int length = 0;
        length = input.length;
        String str = "";
        char[] arr;
        for (int i = 0; i < length; i++) {
            str = this.hMap.get(input[i]);
            if (i == 0) {
                arr = str.toCharArray();
                for (int ai = 0; ai < arr.length; ai++) {
                    this.queue.add(Character.toString(arr[ai]));
                }
                continue;
            } else {
                arr = str.toCharArray();
                List<String> tmp_queue = new ArrayList<>();
                for (String qi : this.queue) {
                    // this.queue.remove(qi);
                    for (int ai = 0; ai < arr.length; ai++) {
                        tmp_queue.add(qi + Character.toString(arr[ai]));
                    }
                    this.queue = tmp_queue;
                }
            }
        }

        if (this.getCache()==1) {
            this.cacheQueue = this.queue;
        }
        System.out.println("result is " + this.queue);
    }

    public void setCache() {
        this.cache = 1;
    }

    public Integer getCache() {
        return this.cache;
    }
}
