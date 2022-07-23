package codeofli.leetcode.dp.intro;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn740 {
    /**
     * leetcode: 直接用数组
     */
    public int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        for (int i = 0; i < nums.length; i ++) {
            trans[nums[i]] += nums[i];
        }

        int[] dp = new int[10001];

        dp[0] = 0;
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + trans[i]);
        }

        return dp[dp.length - 1];
    }
    /**
     * my:离散化了一下
     * f[i] = max{f[i-2]+cnt*i,f[i-1]}
     */
    public int deleteAndEarn1(int[] nums) {
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        Integer maxValue = map.lastKey();
        int[] f = new int[maxValue + 1];
        Integer last1 = null;
        Integer last2 = null;
        Map<Integer, Integer> fMap = new HashMap<>();
        int maxEarn = Integer.MIN_VALUE;
        for (var entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer cnt = entry.getValue();
            //第一个元素
            int putValue;
            if (last1 == null) {
                putValue = key * cnt;
                fMap.put(key, putValue);

            } else { //不是第一个元素
                if (last1 != key - 1) { //可以加入
                    putValue = key * cnt + fMap.get(last1);
                    fMap.put(key, putValue);
                } else { //last1 == key - 1;
                    if (last2 != null) {
                        putValue = Math.max(key * cnt + fMap.get(last2), fMap.get(last1));
                        fMap.put(key, putValue);
                    } else {
                        putValue = Math.max(key * cnt, fMap.get(last1));
                        fMap.put(key, putValue);
                    }
                }
            }

            if (last1 != null) {
                last2 = last1;
            }
            last1 = key;
            maxEarn = Math.max(maxEarn, putValue);
        }
        return maxEarn;
    }

    public static void main(String[] args) {
        DeleteAndEarn740 deleteAndEarn740 = new DeleteAndEarn740();
        System.out.println(deleteAndEarn740.deleteAndEarn(StringTransformUtil.toIntArray("[3,4,2]")));
        System.out.println(deleteAndEarn740.deleteAndEarn(StringTransformUtil.toIntArray("[2,2,3,3,3,4]")));
    }
}
