package com.lmz.algorithm_practice.find.binary_search.max_or_min_judge;

public class MinDays1482 {
    /**
     * 二分查找，判定尝试：f，t,右边界
     */
    public int minDays(int[] bloomDay, int m, int k) {
        //bloomDay.length == n
        //1 <= n <= 10^5
        int n = bloomDay.length;
        if (n < m * k) { //花的总数不够
            return -1;
        }
        //1 <= bloomDay[i] <= 10^9
        int low = 0, high = 1000000000;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (check(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] bloomDay, int m, int k, int x) {
        int n = bloomDay.length;
        int kCnt = k;
        int mCnt = 0;
        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= x){ //花开了
                kCnt--;
                if(kCnt == 0){
                    kCnt = k;
                    mCnt++;
                }
            }else{
                kCnt = k;
            }
        }
        return  mCnt >= m;
    }
}
