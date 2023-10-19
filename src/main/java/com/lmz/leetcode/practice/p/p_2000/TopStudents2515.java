package com.lmz.leetcode.practice.p.p_2000;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2023-10-11 10:24
 */
public class TopStudents2515 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,(a,b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int n = student_id.length;

        Set<String> positiveSet = new HashSet<>(List.of(positive_feedback));
        Set<String> negativeSet = new HashSet<>(List.of(negative_feedback));
        for(int i = 0; i < n; i++){
            String[] split = report[i].split(" ");
            int score = 0;
            for(String s : split){
                if(positiveSet.contains(s)){
                    score += 3;
                }else if(negativeSet.contains(s)){
                    score -= 1;
                }
            }
            if(pq.size() < k){
                pq.add(new int[]{student_id[i], score});
            }else{
                if(pq.peek()[1] < score){
                    pq.poll();
                    pq.add(new int[]{student_id[i], score});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ans.add(pq.poll()[0]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        TopStudents2515 topStudents2515 = new TopStudents2515();
    }
}
