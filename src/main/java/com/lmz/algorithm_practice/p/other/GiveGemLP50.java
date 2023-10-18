package com.lmz.algorithm_practice.p.other;

/**
 * @author: limingzhong
 * @create: 2023-09-15 10:32
 */
public class GiveGemLP50 {

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] opt : operations) {
            gem[opt[1]] += gem[opt[0]] / 2;
            gem[opt[0]] -= gem[opt[0]] / 2;
            // System.out.println(Arrays.toString(gem));
        }
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for(int g : gem){
            max = Math.max(g,max);
            min = Math.min(g,min);
        }
        // System.out.println(max);
        // System.out.println(min);
        return max - min;
    }
}
