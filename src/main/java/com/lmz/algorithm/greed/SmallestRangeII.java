package com.lmz.algorithm.greed;

import java.util.Arrays;

public class SmallestRangeII {
    /**
     * 贪心：所有数值都加K或者都减K，等效于什么都不变。 所以，只需要后面一段往下挪2K，前面一段不动即可。
     */
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        //[0,i]+k,[i+1,n-1]-k;
        // 注意这里有个特殊情况，就是我们压根“不切这一刀”，而是把整个数组全部上移或下移，这也是一种策略。这种策略下的差值是 test.A[len - 1] - test.A[0]
        var smallest = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(nums[n - 1] - k, nums[i] + k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            smallest = Math.min(smallest, max - min);
        }
        return smallest;
    }
}
