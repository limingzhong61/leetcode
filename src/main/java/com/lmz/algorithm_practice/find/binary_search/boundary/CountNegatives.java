package com.lmz.algorithm_practice.find.binary_search.boundary;

public class CountNegatives {
    /**
     * leetcode: 倒序遍历n + M
     */
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        //1 <= m, n <= 100
        int n = grid[0].length;
        int pos = n;
        for (int[] item : grid) {
            for(int i = pos -1; i >= 0; i--){
                if(item[i] < 0){
                    pos--;
                }else{
                    break;
                }
            }
            cnt += n - pos;
        }
        return cnt;
    }
    /**
     * 每一列二分查找 nlogn
     */
    public int countNegatives1(int[][] grid) {
        int cnt = 0;
        for (int[] item : grid) {
            // 找到最右非零数 >0
            int low = 0, high = item.length;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (item[mid] >= 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            cnt += item.length - low;
        }
        return cnt;
    }

}
