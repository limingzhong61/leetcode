package codeofli.leetcode.contest.old.c2022;

public class TemperatureTrend {
    /**
     * 2 <= temperatureA.length == temperatureB.length <= 1000
     */
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int[] a = new int[n];
        int[] b= new int[n];
        for(int i = 1; i < n; i++){
            a[i] = temperatureA[i] - temperatureA[i-1];
        }
        for(int i = 1; i < n; i++){
            b[i] = temperatureB[i] - temperatureB[i-1];
        }
        int res = 0;
        for(int i = 1; i < n; i++) {
            int cnt = 0;
            for(int j = i; j < n; j++){
                if(a[j] * b[j] > 0){
                    cnt++;
                }else  if( a[j] == 0 &&  b[j] == 0){
                    cnt++;
                }else {
                    break;
                }
            }
            res = Math.max(res,cnt);
        }
        return res;
    }
}
