package com.lmz.leetcode.practice.hash;

import java.util.ArrayList;
import java.util.List;

public class GroupThePeople1282 {
    /**
     * 用hash映射size->list,因为范围小，可以用数组映射
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ArrayList[]  sizeMap = new ArrayList[501];
        for (int i = 0; i < sizeMap.length; ++i) {
            sizeMap[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < groupSizes.length; i++){
            sizeMap[groupSizes[i]].add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < sizeMap.length; ++i){
            ArrayList<Integer> sizeList = sizeMap[i];
            if(sizeList.size() > 0){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j = 0; j < sizeList.size(); j++){
                    temp.add(sizeList.get(j));
                    if(j % i == (i-1)){
                        res.add(temp);
                        temp = new ArrayList<>();
                    }
                }
            }
        }
        return res;
    }
}
