package com.lmz.algorithm.hot_100_offer;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate287 {
    /**
     * 空间O(1),时间O(n)
     *  快慢指针：Floyd 判圈算法
     *  为什么会成圈，因为 重复的数字在1-n中，而数组长度为n+1,则因为重复数组都会指向数组中的一个位置。
     *  a = c +n*环长
     */
    public int findDuplicate(int[] nums) {
        int fast = 0,slow = 0;
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);
        //
        fast = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
