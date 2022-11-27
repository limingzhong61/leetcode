package codeofli.leetcode.contest.c321;

public class PivotInteger {
    public int pivotInteger(int n) {
        int left = 0,right = n *(n+1) /2;
        for(int i = 1; i <= n; i++){
            left += i;
            right -= i - 1;
            if(left == right ){
                return i;
            }
        }
        return -1;
    }
}
