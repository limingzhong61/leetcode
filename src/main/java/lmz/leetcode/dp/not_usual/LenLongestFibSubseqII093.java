package lmz.leetcode.dp.not_usual;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-03-31 10:58
 */
public class LenLongestFibSubseqII093 {
    /**
     * 枚举
     */
    public int lenLongestFibSubseq(int[] arr) {
        // val,len
        HashMap<Integer,Integer> map = new HashMap<>();
        //3 <= arr.length <= 1000
        int n = arr.length,maxLen = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map.containsKey(arr[i] - arr[j])){
                    int len = map.getOrDefault(arr[j], 0) + 1;
                    map.put(arr[i], len);
                    maxLen = Math.max(maxLen,len);
                }
            }
            map.putIfAbsent(arr[i],0);
            System.out.printf("%d\n",map.get(arr[i]));
        }
        return maxLen;
    }
}
