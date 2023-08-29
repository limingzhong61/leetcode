package com.lmz.algorithm.other.n1_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-08-26 11:15
 * @description:
 */
public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if(n == 0) return ans;
        int start = nums[0],end = nums[0];

        for(int i = 0; i < n; i++){
            if(i == n - 1 || nums[i+1] != end + 1){
                if(start == end){
                    ans.add(String.valueOf(start));
                }else{
                    ans.add(start + "->"+ end);
                }
                if(i < n - 1)
                    start = end = nums[i+1];
            }else{
                end++;
            }
        }

        return ans;
    }
}
