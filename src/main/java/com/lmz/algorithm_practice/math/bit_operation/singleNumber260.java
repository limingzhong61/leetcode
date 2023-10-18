package com.lmz.algorithm_practice.math.bit_operation;

/**
 * @author: limingzhong
 * @create: 2023-10-16 9:50
 */
public class singleNumber260 {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int num : nums){
            x ^= num;
        }
        // x = a ^ b;
        int y = 0;
        for(int i = 0; i < 31; i++){
            if((x & (1 << i)) != 0){
                y = 1 << i;
                break;
            }
        }
        // System.out.printf("%d,%d\n", x, y);
        int[] ans = new int[2];
        for(int num : nums){
            if((num & y) != 0){
                ans[0] ^= num;
            }else{
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
