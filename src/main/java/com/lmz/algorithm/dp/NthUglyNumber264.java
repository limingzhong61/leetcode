package com.lmz.algorithm.dp;

public class NthUglyNumber264 {
    /**
     * 三指针：p2,p3,p5表示2,3,5的基数index;
     * 用一个数组ugly表示丑数数组
     */
    public int nthUglyNumber(int n) {
        int p2 = 0,p3 = 0,p5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1; // 初始基数都是0
        int index = 1;
        for(int i = 1; i < n; i++){
            int y2 = ugly[p2]* 2;
            int y3 = ugly[p3]* 3;
            int y5 = ugly[p5]* 5;
            int next = Math.min(Math.min(y2,y3),y5);
            ugly[i] = next;
            if(next % 2 == 0){ //2作为因子参与的运算，p2后移
                p2++;
            }
            if(next % 3 == 0){
                p3++;
            }
            if(next % 5 == 0){
                p5++;
            }
        }
        return ugly[n-1];
    }
}
