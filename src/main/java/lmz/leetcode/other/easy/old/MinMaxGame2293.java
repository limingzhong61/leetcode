package lmz.leetcode.other.easy.old;

import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-01-15 16:22
 */
public class MinMaxGame2293 {
    public int minMaxGame(int[] nums) {
        int n = nums.length / 2;
        int[] newNum = null;
        while (n >= 1){
            newNum = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    newNum[i] = Math.min(nums[i * 2], nums[i * 2 +1]);
                }else {
                    newNum[i] = Math.max(nums[i * 2], nums[i * 2 +1]);
                }
            }
            n /= 2;
            nums = newNum;
        }
        return nums[0];
    }
}
