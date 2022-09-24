package codeofli.leetcode.other.easy;

public class MaxScore1422 {
    public int maxScore(String s) {
        //2 <= s.length <= 500
        int n = s.length();
        //[0,i)的0的个数
        int[] zeroCnt = new int[n];
        //[i,n]的0的个数
        int[] oneCnt = new int[n];
        for(int i = 1; i < n; i++){
            if(s.charAt(i-1) == '0'){
                zeroCnt[i] += zeroCnt[i-1];
            }
        }
        oneCnt[n-1] = s.charAt(n-1) == '1'? 1 : 0;
        for(int i = n-2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                oneCnt[i] += oneCnt[i+1];
            }
        }
        int maxScore = -1;
        for(int i = 1; i < n-1; i++){
            maxScore = Math.max(maxScore,zeroCnt[i] + oneCnt[i]);
        }
        return maxScore;
    }
}
