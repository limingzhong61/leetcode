package mars.leetcode.primary.dp;

public class MaxSubArray53 {
    /**
     * my:
     * 状态：sub[i]表示nums[0,i]中以i结尾的最大子序列和值。
     * sub[i] = max(nums[i],sub[i]+nums[i])
     因为需要取最大值
     * 设置maxSum,表示nums[0,i]中的最大子数组和
     * maxSum = max(maxSum,sub[i])
     * 可以省略数组
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sub = nums[0];
        for(int i = 1; i < nums.length; i++){
            sub = Math.max(nums[i],sub+nums[i]);
            maxSum = Math.max(maxSum,sub);
        }
        return  maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray53 maxSubArray53 = new MaxSubArray53();
        System.out.println(maxSubArray53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
