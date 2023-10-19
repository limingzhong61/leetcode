package com.lmz.leetcode.practice.p.p_2000;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author: limingzhong
 * @create: 2023-10-08 10:52
 */
public class StockPrice2034 {
    class StockPrice {
        int maxTimestamp;
        HashMap<Integer, Integer> timePriceMap;
        // price,cnt
        TreeMap<Integer, Integer> prices;
        public StockPrice() {
            maxTimestamp = 0;
            timePriceMap = new HashMap<>();
            prices = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            maxTimestamp = Math.max(maxTimestamp, timestamp);
            int prePrice = timePriceMap.getOrDefault(timestamp, 0);
            timePriceMap.put(timestamp, price);
            // 已经存在该 time -> price的映射，修正它
            if(prePrice > 0){
                int oldCnt = prices.put(prePrice,prices.get(prePrice) - 1);
                if(oldCnt == 1){
                    prices.remove(prePrice);
                }
            }
            prices.put(price, prices.getOrDefault(price,0) + 1);
        }

        public int current() {
            return timePriceMap.get(maxTimestamp);
        }

        public int maximum() {
            return prices.lastKey();
        }

        public int minimum() {
            return prices.firstKey();
        }
    }
}
