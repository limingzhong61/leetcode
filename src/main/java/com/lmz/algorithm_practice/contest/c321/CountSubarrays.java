package com.lmz.algorithm_practice.contest.c321;

import java.util.*;

public class CountSubarrays {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == k){
                idx = i;
                break;
            }
        }
        // len,cnt;
        //ArrayList<int[]>[]  rec = new ArrayList[n];
        //rec[1] = new ArrayList<>();
        //rec[1].add();
        //int res = 1;
        //for(int i = 1; i < n; i++){
        //
        //}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{idx,idx,1});
        int res = 0;
        HashSet<String> set = new HashSet<>();
        set.add(idx + "-" + idx);
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int left = poll[0];
            int right = poll[1];
            int cnt = poll[2];
            int len = right - left + 1;
            if((len + 1) / 2 == cnt ){
                res++;
                System.out.printf("%d,%d,%d",left,right,cnt);
            }
            // 左边扩展
            if(left > 0){
                int nextCnt = cnt;
                int nextLeft = left - 1;
                String s = nextLeft + "-" + right;
                if(!set.contains(s)){
                    if(nums[nextLeft] < nums[idx]){
                        nextCnt++;
                    }
                    set.add(s);
                    q.add(new int[]{nextLeft,right,nextCnt});
                }

            }
            // 右边扩展
            if(right < n - 1){
                int nextCnt = cnt;
                int nextRight = right + 1;
                String s = left + "-" + right;
                if(!set.contains(s)){
                    if(nums[nextRight] < nums[idx]){
                        nextCnt++;
                    }
                    set.add(s);
                    q.add(new int[]{left,nextRight,nextCnt});
                }

            }
        }
        return res;
    }
}
