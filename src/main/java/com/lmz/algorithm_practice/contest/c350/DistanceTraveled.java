package com.lmz.algorithm_practice.contest.c350;

/**
 * @author: limingzhong
 * @create: 2023-06-18 10:31
 */
public class DistanceTraveled {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5) {
            int five = mainTank / 5;
            ans += five * 5 * 10;
            mainTank =  mainTank % 5 + Math.min(additionalTank,five);
            additionalTank -= five;
            if(additionalTank < 0) additionalTank = 0;
        }
        return ans;
    }
}
