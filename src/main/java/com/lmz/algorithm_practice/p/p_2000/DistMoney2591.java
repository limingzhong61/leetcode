package com.lmz.algorithm_practice.p.p_2000;

/**
 * @author: limingzhong
 * @create: 2023-09-22 9:45
 */
public class DistMoney2591 {
    public int distMoney(int money, int children) {
        int[] f = new int[children];
        int cnt = 0;
        for(int i = 0; i < children - 1; i++){
            int nextMoney = money - 8;
            if(children - i - 1 <= money){
                 money = nextMoney;
                 cnt++;
            }else{
                return cnt;
            }
        }
        if(money == 4)cnt--;
        return cnt;
    }
}
