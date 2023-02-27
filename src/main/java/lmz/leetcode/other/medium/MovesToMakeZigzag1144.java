package lmz.leetcode.other.medium;

/**
 * @author: limingzhong
 * @create: 2023-02-27 9:07
 */
public class MovesToMakeZigzag1144 {
    /**
     * 两种情况，分别统计
     * 只能减少
     * 每次 操作 会从中选择一个元素并 将该元素的值减少 1。
     */
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        // 奇数大,减小偶数
        int oddCnt = 0;
        for (int i = 0; i < n; i += 2) {
            int minVal = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                minVal = Math.min(minVal, nums[i - 1]);
            }
            if (i + 1 < n) {
                minVal = Math.min(minVal, nums[i + 1]);
            }
            if(minVal <= nums[i]){
                oddCnt += nums[i] - minVal   + 1;
            }
            System.out.printf("%d %d %d\n",nums[i],minVal,oddCnt);
        }
        // 偶数大,减小奇数
        int evenCnt = 0;
        for (int i = 1; i < n; i += 2) {
            int minVal = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                minVal = Math.min(minVal, nums[i - 1]);
            }
            if (i + 1 < n) {
                minVal = Math.min(minVal, nums[i + 1]);
            }
            if(minVal <= nums[i]){
                oddCnt += nums[i] - minVal   + 1;
            }
            System.out.printf("%d %d %d\n",nums[i],minVal,evenCnt);

        }

        return  Math.min(oddCnt,evenCnt);
    }
}
