package com.lmz.algorithm_practice.math.bit_operation.similar_problems;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

/**
 * 剑指offer
 */
public class SingleNumber56II {
    /**
     统计每一个数2进制中第i位为1的次数和到counts中
     如果counts[i] % 3 == 1,则只可能是唯一出现一次的数的位数
     将这些位组合成一个数则为ans
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int x : nums){
            for(int i = 0; i < 32; i++){
                counts[i] += x & 1; // 更新第 i 位
                x >>>= 1;           // 第 i 位 --> 第 i + 1 位
            }
        }
        int ans = 0;
        for(int i = 0; i < 32; i++){
            if(counts[i] % 3 == 1){
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber56II singleNumber56II = new SingleNumber56II();
        //System.out.println(singleNumber56II.singleNumber(TransformUtil.toIntArray("[3,4,3,3]")));
        System.out.println(singleNumber56II.singleNumber(TransformUtil.toIntArray("[5,2,2,2,5,5,4]")));
        System.out.println(singleNumber56II.singleNumber(TransformUtil.toIntArray("[5,2,2,2,5,5,4]")) == 4);
    }
}
