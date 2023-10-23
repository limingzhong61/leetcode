package com.lmz.leetcode.practice.p.easy.old;

import java.util.ArrayList;
import java.util.List;

public class BuildArray1441 {
    /**
     * 模拟
     */
    public List<String> buildArray(int[] target, int n) {
        int start = 1;
        List<String> res = new ArrayList<>();
        for(int x : target){
            while(start != x){
                start++;
                res.add("Push");
                res.add("Pop");
            }
            start++;
            res.add("Push");
        }
        return res;
    }

}
