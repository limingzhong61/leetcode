package lmz.leetcode.dp;

/**
 * @author: limingzhong
 * @create: 2023-04-19 21:54
 */
public class LongestSubstring {
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        // f[i][j] 表示 0-(i-1),0-(j-1)的数值；
        int[][] f = new int[n][m];
        char[] csA = A.toCharArray(),csB = B.toCharArray();
        int max = 0;
        String res = null;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(csA[i] == csB[j]){
                    f[i+1][j+1] = f[i][j] + 1;
                    if(max < f[i+1][j+1]){
                        max = f[i+1][j+1];
                        res = A.substring(i - max + 1, i+1);
                    }
                }
            }
        }
        System.out.println(res);
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.findLongest("1AB2345CD", 9, "12345EF", 7));
    }
}
