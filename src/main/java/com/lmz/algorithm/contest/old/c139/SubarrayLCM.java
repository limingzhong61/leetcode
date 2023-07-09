package com.lmz.algorithm.contest.old.c139;

public class SubarrayLCM {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == k){
                cnt++;
            }
            int temp = nums[i];
            for(int j = i+1; j <n; j++){
                int gcd = gcd(temp,nums[j]);
                System.out.printf("%d",gcd);
                System.out.printf("");
                if(nums[i] * temp /gcd == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
