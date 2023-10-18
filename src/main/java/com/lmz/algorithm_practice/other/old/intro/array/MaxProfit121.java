package com.lmz.algorithm_practice.other.old.intro.array;

public class MaxProfit121 {
    /**
     * my:
     * min[i],表示prices[0,i]中最小price
     * profit[i],表示表示prices[0,i]中最大利润
     * profit[i] = prices[i]-min[i].
     *
     */
    public int maxProfit(int[] prices) {
        int minPrices = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            minPrices = Math.min(maxProfit,prices[i]);
            maxProfit = Math.max(prices[i] - minPrices,maxProfit);
        }
        return maxProfit;
    }
}
