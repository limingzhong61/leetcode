package codeofli.leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayRankTransform1331 {
    /**
     * [100,100,100,101]
     * [1,1,1,2]
     */
    public int[] arrayRankTransform(int[] arr) {
        //0 <= arr.length <= 10^5
        int[] temps = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temps);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < temps.length; i++) {
            if (!map.containsKey(temps[i])) {
                map.put(temps[i], index++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
