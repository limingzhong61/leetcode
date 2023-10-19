package com.lmz.leetcode.practice.math;

public class TrailingZeroes172 {
    /**
     * 统计一个数y含有y/x（向下取整）个x因子
     * 统计质因子5出现的次数
     * 结尾的0只有 2*5可以组成，而2的数量是大于5的，故统计出现5的数目即可
     * 0 <= n <= 10^4
     */
    public int trailingZeroes(int n) {
        int cnt5 = 0;
        for(long k = 5; k<= n; k *= 5){
            cnt5 += n / k;
        }
        return cnt5;
    }


    /**
     * 统计质因子5出现的次数
     * 结尾的0只有 2*5可以组成，而2的数量是大于5的，故统计出现5的数目即可
     *
     * 0 <= n <= 10^4
     */
    public int trailingZeroes1(int n) {
        int cnt5 = 0;
        int time5 = 1;
        for(long k = 5; k<= n; k *= 5){
            for(int i = 1; i <= n; i++){
                if(i % k == 0){
                    cnt5 += time5;
                }
            }
        }
        return cnt5;
    }
}
