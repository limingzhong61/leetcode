package lmz.leetcode.contest.old.c305;

public class LongestIdealString6138 {
    /**
     * 1 <= s.length <= 10^5
     * 0 <= k <= 25
     * s 由小写英文字母组成
     */
    public int longestIdealString(String s, int k) {
        int n = s.length();
        boolean[][] lenItems = new boolean[n+1][26]; //长度为len可选字符
        char[] chars = s.toCharArray();
        lenItems[1][chars[0] -'a'] = true;
        int len = 1;
        for(int i = 1; i < n; i++){
            int canLen = 0;
            int c = chars[i] - 'a';
            for(int l = len; l >= 1; l--){
                int right = Math.min(25,c+k);
                int left = Math.max(0,c-k);
                for(int j = left; j <= right; j++){
                    if(lenItems[l][j]){
                        canLen = l;
                        break;
                    }
                }
                if(canLen != 0){
                    break;
                }
            }
            lenItems[canLen+1][c] = true;
            len = Math.max(canLen+1,len);
        }
        return  len;
    }
}
