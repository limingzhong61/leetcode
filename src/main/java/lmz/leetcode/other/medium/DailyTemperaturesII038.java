package lmz.leetcode.other.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperaturesII038 {
    /**
     * 单调栈，找到下一个更大的值
     */
    public int[] dailyTemperatures(int[] temperatures) {
        //<val,idx>
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return res;
    }    
}
