package codeofli.leetcode.monotonic_stack_or_queue;

import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementsII503 {
    /**
     * 在循环数组中找到下一个更大元素的位置
     * 思路：先找到数组中最大的元素，该元素一定没有更大元素，然后从后往前用单调队列即可
     */
    public int[] nextGreaterElements(int[] nums) {
        int maxIndex = 0;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        int[] nextBig = new int[n];
        nextBig[maxIndex] = -1;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[maxIndex]);
        for(int i = maxIndex - 1; (i + n) % n  != maxIndex; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[(i + n) % n]){
                stack.poll();
            }
            if(stack.isEmpty()){
                nextBig[(i + n) % n] = -1;
            }else{
                nextBig[(i + n) % n] = stack.peek();
            }

            stack.push(nums[(i + n) % n]);
        }
        return nextBig;
    }
}
