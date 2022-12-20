package lmz.leetcode.contest.old.c306;

import java.util.Arrays;

public class edgeScore {
    class Pair{
        int index;
        long score;
    }
    public int edgeScore(int[] edges) {
        int n = edges.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Pair();
            pairs[i].index = i;
        }
        for(int i = 0; i < n; i++){
            pairs[edges[i]].score += i;
            if(pairs[edges[i]].score < 0){
                pairs[edges[i]].score = Long.MAX_VALUE;
            }
        }
        Arrays.sort(pairs,(a,b) ->{
            if(a.score == b.score){
                return a.index - b.index;
            }
            return  (b.score - a.score) > 0 ? 1 : -1;
        });
        return pairs[0].index;
    }
}
