package lmz.algorithm.find.binary_search;

import java.util.Random;

/**
 * @author: limingzhong
 * @create: 2023-03-23 17:20
 */
public class SolutionII071 {
    class Solution {
        int[] w;
        int[] preSum;
        Random random = new Random();
        public Solution(int[] w) {
            this.w = w;
            int n = w.length;
            preSum = new int[n + 1];
            for(int i = 0; i < n; i++){
                preSum[i + 1] = preSum[i] + w[i];
            }
        }

        public int pickIndex() {
            int x = (int) (Math.random() * preSum[preSum.length-1]) + 1;
            return binSearch(preSum,x) - 1;
        }

        /**
         * 找到<x 的idx
         */
        private int binSearch(int[] preSum, int target) {
            int low = 1,high = preSum.length - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(preSum[mid] < target){
                    low = mid + 1;
                }else{
                    high = high - 1;
                }
            }
            return low;
        }
    }

}
