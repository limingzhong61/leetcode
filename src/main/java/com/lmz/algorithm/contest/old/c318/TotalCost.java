package com.lmz.algorithm.contest.old.c318;

import java.util.PriorityQueue;

/**
 * @author: codeofli
 * @create: 2022-11-06 10:51
 */
public class TotalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        //<cost,idx>
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int n = costs.length;
        int left = 0,right = n -1;
        for(int i = 0; i < candidates && left <= right; i++){
            pq.add(new int[]{costs[left],left});
            left++;
        }
        for(int i = 0; i < candidates && left <= right; i++){
            pq.add(new int[]{costs[right],right});
            right--;
        }
        long res = 0;
        //1 <= k, candidates <= costs.length
        for(int i = 0; i < k && pq.size() > 0; i++){
            int[] pair = pq.poll();
            // System.out.println(Arrays.toString(pair));
            res += pair[0];
            if(left <= right){ // 还有剩余候选者
                if(pair[1] <= left){
                    pq.add(new int[]{costs[left],left});
                    left++;
                }else{
                    pq.add(new int[]{costs[right],right});
                    right--;
                }
            }
        }
        return res;
    }
}
