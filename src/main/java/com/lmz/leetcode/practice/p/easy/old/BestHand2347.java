package com.lmz.leetcode.practice.p.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-02-20 9:34
 */
public class BestHand2347 {
    /**
     * 1 <= ranks[i] <= 13
     */
    public String bestHand(int[] ranks, char[] suits) {

        char startChar = suits[0];
        boolean suit = true;
        for(int i = 1; i < suits.length; i++){
            if(suits[i] == startChar){
                suit = false;
                break;
            }
        }
        if(suit){
            return "Flush";
        }

        int[] cnt = new int[14];
        for(int x : ranks){
            cnt[x] ++;
            if(cnt[x] >= 3){
                return "Three of a Kind";
            }
        }

        for(int x : cnt){
            System.out.println(x);
            if(cnt[x] >= 2){
                return "Pair";
            }
        }

        return "High Card";
    }
}
