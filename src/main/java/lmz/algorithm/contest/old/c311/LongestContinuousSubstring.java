package lmz.algorithm.contest.old.c311;

public class LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        //1 <= s.length <= 105
        int maxLen = 1;
        for(int i = 0; i < len; i++){
            int j = i;
            while( j + 1 < len && cs[j] + 1 == cs[j+1]){
                j++;
            }
            maxLen = Math.max(j - i + 1,maxLen);
        }
        return maxLen;
    }
}
