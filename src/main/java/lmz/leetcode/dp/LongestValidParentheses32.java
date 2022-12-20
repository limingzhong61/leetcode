package lmz.leetcode.dp;

public class LongestValidParentheses32 {
    /**
     * dp[i]表示以i结尾的最长有效括号长度
     */
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        //0 <= s.length <= 3 * 104
        int n = cs.length;
        int[] f = new int[n];
        int maxLen = 0;
        for(int len  = 2; len <= n; len +=2){
            for(int i = 0; i+len-1 < n; i++){
                if('(' == cs[i] && cs[i +len-1] == ')' && ( f[i+1] == i+len-2 || i + 1 == i+len-1)){
                    f[i] = i + len-1;
                    maxLen = Math.max(maxLen,len);
                }
                for(int k = i+2; k < i+len; k +=2){
                    if(f[i] == k-1 && f[k] == i+len-1){
                        f[i] = i+len-1;
                        maxLen = Math.max(maxLen,len);
                    }
                }

            }
        }
        return  maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 longestValidParentheses32 = new LongestValidParentheses32();
        testCase(longestValidParentheses32, "(()", 2);
        testCase(longestValidParentheses32, ")()())", 4);
        testCase(longestValidParentheses32, "", 0);
        testCase(longestValidParentheses32, "()(())", 6);
    }

    private static void testCase(LongestValidParentheses32 longestValidParentheses32, String s, int x) {
        System.out.println(longestValidParentheses32.longestValidParentheses(s));
        System.out.println(longestValidParentheses32.longestValidParentheses(s) == x);
    }
}
