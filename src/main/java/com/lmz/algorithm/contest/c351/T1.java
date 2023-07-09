package com.lmz.algorithm.contest.c351;

/**
 * @author: limingzhong
 * @create: 2023-06-25 10:29
 */
public class T1 {
    //nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 1
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length,ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int x = String.valueOf(nums[i]).charAt(0) - '0';
                int y = nums[j] % 10;
                if(gcd(x,y) == 1){
                    // System.out.println("%d,%d\n",)
                    ans++;
                }
            }
        }
        return ans;
    }

    static long gcd(long y, long x) {
        while(x != 0){
            long temp = y % x;
            y = x;
            x = temp;
        }
        return y;
    }
}
