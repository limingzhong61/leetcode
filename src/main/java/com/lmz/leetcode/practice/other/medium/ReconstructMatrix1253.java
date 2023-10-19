package com.lmz.leetcode.practice.other.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-06-29 16:03
 */
public class ReconstructMatrix1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = IntStream.of(colsum).sum();
        List<List<Integer>> ans = new ArrayList<>();
        if(sum != upper + lower){
            return ans;
        }
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        int n = colsum.length;
        for(int i = 0; i < n; i++){
            int a = 0, b = 0;
            if(colsum[i] == 2){
                a = 1;
                b = 1;
                upper--;
                lower--;
            }else if(colsum[i] == 1){
                //  先将一行和最大的置为1
                if(upper >= lower){
                    upper--;
                    a = 1;
                }else{
                    lower--;
                    b = 1;
                }
            }
            if(lower < 0 || upper < 0) return new ArrayList<>();
            // System.out.printf("%d,%d\n",upper,lower);
            ans.get(0).add(a);
            ans.get(1).add(b);
        }
        return  ans;
    }
}
