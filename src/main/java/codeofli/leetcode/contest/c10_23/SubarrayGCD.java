package codeofli.leetcode.contest.c10_23;

/**
 * @author: codeofli
 * @create: 2022-10-23 10:43
 */
public class SubarrayGCD {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                res++;
            }
            boolean in = false;
            int start = nums[i];
            for (int j = i + 1; j < n; j++) {
                start = gcd(start,nums[j]);
                in = true;
                if(start == k){
                    res++;
                }
            }
            //if(in && start == k){
            //    res++;
            //}
        }
        return res;
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
