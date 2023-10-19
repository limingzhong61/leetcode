package com.lmz.leetcode.practice.greed;

public class IncreasingTriplet334 {
    /**
     * 贪心
     * d[len]表示形成长度为len的递增序列的最后元素最小值，如果num>d[len]则，d[len+1]=num;
     * 如果小于d[len]则，插入到d[i]中1<= i <= len,当 d[i] >num > d[i-1]时，d[i] = num
     * 如果存在第三小的数，则肯定递增的三元子序列。
     */
    public boolean increasingTriplet(int[] nums) {
        //1 <= nums.length <= 5 * 105
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int needLen = 3;
        int[] d = new int[needLen + 1];
        int len = 1;
        d[1] = nums[0];
        d[0] = Integer.MIN_VALUE; //方便状态转移
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                len++;
                if (len == needLen) {
                    return true;
                }
                d[len] = nums[i];
            }else{
                for(int j = 1; j <= len; j++){
                    if( nums[i] > d[j-1] && nums[i] <d[j]){
                        d[j] = nums[i];
                    }
                }
            }
        }
        return false;
    }
}
