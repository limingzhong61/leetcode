package lmz.algorithm.find.binary_search.max_or_min_judge;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-06-01 9:40
 */
public class MaximumTastiness2517 {
    /**
     * 这种最小的最大，最大的最小，基本都是二分……
     */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = (int) 1e9;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(judge(price,k,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean judge(int[] price, int k, int gap) {
        int start = price[0];
        k--;
        for(int x : price){
            if(x - start >= gap){
                k--;
                start = x;
            }
        }
        return k <= 0;
    }
}
