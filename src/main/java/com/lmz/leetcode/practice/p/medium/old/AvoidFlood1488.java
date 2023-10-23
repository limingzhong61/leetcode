package com.lmz.leetcode.practice.p.medium.old;

import java.util.*;

public class AvoidFlood1488 {
    class Solution{
        public int[] avoidFlood(int[] rains) {
            int n = rains.length;
            HashSet<Integer> rained = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            int[] ans = new int[n];
            for(int i = 0; i < n; i++){
                if(rains[i] == 0){
                    q.add(i);
                }else{
                    ans[i] = -1;
                    if(rained.contains(rains[i])){
                        if(q.isEmpty()){
                            return new int[]{};
                        }else{
                            System.out.printf("%d,%d\n",q.peek(), rains[i]);
                            ans[q.poll()] = rains[i];
                        }
                    }
                    rained.add(i);
                }
            }
            return ans;
        }

    }



    /**
     * 贪心 + 二分(用TreeSet省略自己实现)
     * 将晴天的日期全部记录到 set<int> zero 中
     * 使用 map<int, int> water 来记录每个湖泊上一次下雨的日期
     */
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        // 用map记录每个湖泊上一次下雨的日期
        Map<Integer,Integer> lastDayMap = new HashMap<>();
        int[] res = new int[n];
        // 用一个栈记录不下雨的日子
        TreeSet<Integer> zero = new TreeSet<>();
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(rains[i] == 0){
               zero.add(i);
               res[i] = 1; //随便抽一个
            }else{
                res[i] = -1;
                if(lastDayMap.containsKey(rains[i])){
                    Integer draw = zero.ceiling(lastDayMap.get(rains[i]));
                    if(draw == null){
                        return new int[0];
                    }
                    res[draw] = rains[i];
                    zero.remove(draw);
                }
                lastDayMap.put(rains[i],i);
            }
        }
        return res;
    }
}
