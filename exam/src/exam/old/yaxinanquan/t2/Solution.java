package exam.old.yaxinanquan.t2;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int maxProducts (int[] prices, int target) {
        // write code here
        int n = prices.length;
        int ans = 0;
        for(int i = 0; i < n ;i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += prices[j];
                System.out.printf("%d,%d,%d\n",i,j, sum);
                if(sum > target) break;
                ans = Math.max(ans,j - i + 1);
            }
        }
        return ans;
    }
}