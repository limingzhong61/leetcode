package lmz.leetcode.data_structure.array_and_strings.two_pointer;

import java.util.Arrays;

public class MinSubArrayLen209 {
    /**
     * leetcode:前缀和+滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int minLength = n + 1;
        int[] sum = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int targetSum = target + sum[i - 1];
            int bound = Arrays.binarySearch(sum, targetSum);
            if (bound < 0) {
                bound = -(bound + 1);
            }
            if(bound <= n){
                minLength = Math.min(bound-(i-1), minLength);
            }
        }
        return minLength == n + 1 ? 0 : minLength;
    }

    /**
     * leetcode:滑动窗口
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;

        int minLength = n + 1;
        int start = 0, end = 0;
        //sum = sum[start,end]
        int sum = 0;

        while (end < n) {
            sum += nums[end];
            //可能前进几个start
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minLength == n + 1 ? 0 : minLength;
    }

    /**
     * my:滑动窗口
     */
    public int minSubArrayLen1(int target, int[] nums) {

        int n = nums.length;
        int sum = 0;
        int minLength = n + 1;
        for (int i = 0, j = 0; i <= j; ) {
            //符合条件
            if (sum >= target) {
                int length = j - i;
                minLength = Math.min(length, minLength);
                sum -= nums[i];
                i++;
            } else { //sum < target
                if (j == n) { //j已经到边界了，不能再添加了
                    break;
                }
                sum += nums[j];
                j++;
            }
        }
        return minLength == n + 1 ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen209 minSubArrayLen209 = new MinSubArrayLen209();
        System.out.println(minSubArrayLen209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen209.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
