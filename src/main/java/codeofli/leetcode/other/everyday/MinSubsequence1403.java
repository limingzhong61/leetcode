package codeofli.leetcode.other.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        List<Integer> res = new ArrayList<>();
        int selectSum = 0;
        for(int i = nums.length -1 ; i >= 0; i++){
            selectSum += nums[i];
            if(selectSum > sum - selectSum){
                break;
            }
        }
        return res;
    }
}
