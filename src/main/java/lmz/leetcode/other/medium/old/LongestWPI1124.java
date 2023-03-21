package lmz.leetcode.other.medium.old;

import lmz.my.leetcode.TransformUtil;

import java.util.ArrayDeque;

public class LongestWPI1124 {
    /**
     * 前缀和+单调栈
     */
    public int longestWPI(int[] hours) {
        int n = hours.length;
        var s = new int[n +1];
        for(int i = 1; i <= n; i++){
            if(hours[i - 1] > 8){
                s[i] = s[i-1] + 1;
            }else{
                s[i] = s[i - 1] - 1;
            }
        }

        // 单调栈
        var stack = new ArrayDeque<Integer>();
        stack.push(0); // s[0]
        for(int i = 0; i < n; i++){
            if(s[i] < s[stack.peek()]){
                stack.push(i);  // 感兴趣的 i
            }
        }

        int res = 0;
        for(int i = n; i >= 0; i--){
            while (!stack.isEmpty() && s[i] > s[stack.peek()]){
                res = Math.max(i - stack.pop(), res); // [栈顶,i) 可能是最长子数组
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestWPI1124 longestWPI1124 = new LongestWPI1124();
        //System.out.println(longestWPI1124.longestWPI(TransformUtil.toIntArray("[9,9,6,0,6,6,9]")));
        System.out.println(longestWPI1124.longestWPI(TransformUtil.toIntArray("[6,6,9]")));
    }
}
