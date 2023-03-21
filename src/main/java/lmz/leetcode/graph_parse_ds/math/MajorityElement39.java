package lmz.leetcode.graph_parse_ds.math;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement39 {
    /**
     * 因为求数组中出现次数超过一半的数字，
     * 摩尔投票法： 核心理念为 票数正负抵消 。
     * 此方法时间和空间复杂度分别为 O(N) 和 O(1) ，为本题的最佳解法。
     */
    //也可以理解成混战极限一换一，不同的两者一旦遇见就同归于尽，最后活下来的值都是相同的，即要求的结果
    public int majorityElement(int[] nums) {
        int votes = 0,candidate  = -1;
        for(int i : nums){
            if(votes == 0){
                candidate  =  i;
            }
            votes += candidate == i ? 1 : -1;
        }
        // 验证 x 是否为众数
        //for(int num : nums)
        //    if(num == x) count++;
        return candidate;
    }
    /**
     * sort
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    /**
     * hashmap
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2 + 1;
        for(int i : nums){
            int cnt = map.getOrDefault(i,0)+1;
            if(cnt >= half){
                return i;
            }
            map.put(i,cnt);
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement39 majorityElement = new MajorityElement39();
        System.out.println(majorityElement.majorityElement(TransformUtil.toIntArray("[1, 2, 3, 2, 2, 2, 5, 4, 2]")));

    }
}
