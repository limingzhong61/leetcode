package codeofli.leetcode.contest.test;

public class MinimumReplacement6144 {
    /**
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * 将数组变成元素按 非递减 顺序排列的数组
     */
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long pre = nums[n - 1];
        long cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > pre){
                long pTimes = nums[i] / pre;
                cnt += pTimes - 1;
                long y = nums[i] - (pTimes - 1) * pre;
                if(y == pre){ // 能整除
                    continue;
                }
                if(y % 2 == 0){
                    pre = y / 2;
                }else {
                    pre = y / 2 - 1;
                }
                cnt++;
            }else{
                pre = nums[i];
            }
        }
        return  cnt;
    }
}
