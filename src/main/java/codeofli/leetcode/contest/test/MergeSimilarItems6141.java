package codeofli.leetcode.contest.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeSimilarItems6141 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] item : items1){
            map.put(item[0],item[1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int[] item : items2){
            map.put(item[0],item[1] + map.getOrDefault(item[0],0));
        }
        for(var entry : map.entrySet()){
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            res.add(temp);
        }
        res.sort((a,b) -> a.get(0) - b.get(0));
        return  res;
    }
}
