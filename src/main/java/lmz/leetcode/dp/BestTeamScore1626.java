package lmz.leetcode.dp;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class BestTeamScore1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] combine = new int[n][2];
        for(int i = 0; i < n; i++){
            combine[i][0] = scores[i];
            combine[i][1] = ages[i];
        }
        Arrays.sort(combine,(a,b)->{
            if(a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(combine[0][0],combine[0][0]);
        int res= 0;
        for(int i = 1; i < n; i++){
            int score = combine[i][0];
            int max = 0;
            for(var entry : map.entrySet()){
                if(entry.getKey() > score){
                    break;
                }
               max = Math.max(entry.getValue(),max);
            }
            map.put(score,max+score);
            res = Math.max(res,max+score);
            System.out.printf("%d,%d,%d\n",score,max,res);
        }
        return res;
    }

    public static void main(String[] args) {
        BestTeamScore1626 bestTeamScore1626 = new BestTeamScore1626();
        System.out.println(bestTeamScore1626.bestTeamScore(TransformUtil.toIntArray("[1,3,5,10,15]"),
                TransformUtil.toIntArray("[1,2,3,4,5]")));
    }
}
