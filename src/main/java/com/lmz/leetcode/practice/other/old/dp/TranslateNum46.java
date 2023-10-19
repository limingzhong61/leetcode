package com.lmz.leetcode.practice.other.old.dp;

public class TranslateNum46 {
    /**
     * dp:
     * dp[i],以i结尾有多少种解法
     * dp[i] = dp[i+1]
     * if(dp
     */
    public int translateNum(int num) {
        int[] dp = new int[11];
        int[] nums = new int[11];
        //获取每一位的数字
        int index = 0;
        //获取数字位数，用do-while,防止0的情况
        do {
            nums[index++] = num % 10;
            num /= 10;
        } while (num != 0);
        dp[index] = 1; //填充边界，便于计算
        dp[index - 1] = 1;
        for (int i = index - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            //“06”翻译过来还是6,不算
            if (nums[i + 1] != 0 && nums[i + 1] * 10 + nums[i] <= 25) {
                dp[i]  += dp[i + 2];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        TranslateNum46 translateNum46 = new TranslateNum46();
        System.out.println(translateNum46.translateNum(12258));
        System.out.println(translateNum46.translateNum(12258) == 5);
        System.out.println(translateNum46.translateNum(506));
        System.out.println(translateNum46.translateNum(506) == 1);
        System.out.println(translateNum46.translateNum(0));
        System.out.println(translateNum46.translateNum(0) == 1);
    }
}
