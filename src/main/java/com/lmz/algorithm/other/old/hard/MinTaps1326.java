package com.lmz.algorithm.other.old.hard;

import com.lmz.my.leetcode.TransformUtil;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-02-21 10:02
 */
public class MinTaps1326 {
    /**
     * 1 <= n <= 104
     * 贪心，从左往右遍历，确保左侧全部灌溉的前提下，最大化右侧边界，新的龙头入栈时弹出栈顶可被替换的水龙头
     */
    public int minTaps(int n, int[] ranges) {
        var f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);

        int[][] cal = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            cal[i][0] = i - ranges[i];
            if(cal[i][0] <0){
                cal[i][0] = 0;
            }
            cal[i][1] = i + ranges[i];
        }
        Arrays.sort(cal,(a,b) -> a[0] - b[0]);
        if(cal[0][0] > 0){
            return -1;
        }

        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i <= n; i++){
            int[] range = cal[i];
                if(range[0] == range[1]) continue;
            while(!stack.isEmpty() && stack.peek()[0] >= range[0] && stack.peek()[1] <= range[1]){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek()[1] < range[1]){
                stack.push(range);
            }
        }
        if(stack.isEmpty() || stack.peek()[1] < n){
            return  -1;
        }

        return stack.size();
    }


    public static void main(String[] args) {
        MinTaps1326 minTaps1326 = new MinTaps1326();
        testCase(minTaps1326, 5, "[3,4,1,1,0,0]", 1);
        testCase(minTaps1326, 3, "[0,0,0,0]", -1);
        testCase(minTaps1326, 7, "[1,2,1,0,2,1,0,1]", 3);
    }

    private static void testCase(MinTaps1326 minTaps1326, int n, String original, int x) {
        System.out.println(minTaps1326.minTaps(n, TransformUtil.toIntArray(original)));
        System.out.println(minTaps1326.minTaps(n, TransformUtil.toIntArray(original)) == x);
    }


}
