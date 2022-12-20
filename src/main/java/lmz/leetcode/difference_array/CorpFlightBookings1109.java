package lmz.leetcode.difference_array;

import java.util.Arrays;

public class CorpFlightBookings1109 {

    /**
     * 差分数组： d[i] = a[i]-a[i-1]
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] fights = new int[n+1];
        int[] d = new int[n+2];
        for(int[] booking : bookings){
            d[booking[0]] += booking[2];
            d[booking[1] + 1] -= booking[2];
        }
        fights[0] = d[0] = 0;
        for(int i = 1; i <= n; i++){
            fights[i] = d[i] + fights[i-1];
        }
        return Arrays.copyOfRange(fights,1,n+1);
    }
}
