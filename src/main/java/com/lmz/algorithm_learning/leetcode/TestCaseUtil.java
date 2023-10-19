package com.lmz.algorithm_learning.leetcode;


import com.lmz.leetcode.practice.dp.Rob231;

/**
 * @author: limingzhong
 * @create: 2023-06-26 14:47
 */
public class TestCaseUtil {
    public static void testCase(Rob231 rob231, String s, int i) {
        System.out.println(rob231.rob(TransformUtil.toIntArray(s)));
        boolean sucess = rob231.rob(TransformUtil.toIntArray(s)) == i;
        System.out.println(sucess);
        if(!sucess){
            System.err.println(false);
        }
    }
}
