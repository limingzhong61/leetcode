package lmz.leetcode.contest.c320;

import java.util.Arrays;
import java.util.HashMap;

public class UnequalTriplets2475 {
    /**
     * hash + 对称性（顺序不重要），只需要x的次数即可。
     */
    public int unequalTriplets(int[] nums) {
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        for(var i : nums){
            cntMap.put(i,cntMap.getOrDefault(i,0) + 1);
        }
        int a = 0, c = nums.length,res = 0;
        for(var entry : cntMap.entrySet()){
            int b = entry.getValue();
            res += a * b * c;
            a += entry.getValue();
            c -= entry.getValue();
        }
        return res;
    }
    /**
     * 排序+计算贡献值：
     *对于 x，设：
     * 小于 x 的数有 a 个；
     * 等于 x 的数有 b 个；
     * 大于 x 的数有 c 个。
     * 那么 x 对答案的贡献是 abc。
     * 累加所有贡献，得到答案。
     */
    public int unequalTriplets2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n - 1 && nums[j+1] == nums[j]){
                j++;
            }
            int a = i;
            int b = j - i + 1;
            int c = n - j - 1;
            res += a * b * c;
        }
        return res;
    }

    /**
     * 暴力法
     * O(n^2)
     */
    public int unequalTriplets1(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if(nums[i] != nums[j]){
                    for (int k = j + 1; k < n; k++) {
                        if(nums[i] != nums[k] && nums[j] != nums[k]){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
