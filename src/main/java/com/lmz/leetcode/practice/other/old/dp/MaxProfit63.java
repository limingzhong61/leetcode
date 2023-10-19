package com.lmz.leetcode.practice.other.old.dp;

public class MaxProfit63 {
    /**
     * 思路：因为只能交易一次，这只需要买入时是最低价格买入即可
     * min[i]：前[0,i]的最小值
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(prices[i],minPrice);
            maxProfit = Math.max(prices[i]-minPrice,maxProfit);
        }
        return  maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit63 maxProfit63 = new MaxProfit63();
        System.out.println(maxProfit63.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit63.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(maxProfit63.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit63.maxProfit(new int[]{7,6,4,3,1}) == 0);
    }
}
