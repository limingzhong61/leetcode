package lmz.leetcode.other.old.intro;

public class IsSubsequence392 {
    /**
     * leetcode:dp-预处理
     * 预处理出对于 t 的每一个位置，从该位置开始往后每一个字符第一次出现的位置。
     * 令 `f[i][j]` 表示字符串 t 中从**位置 i 开始往后字符 j 第一次出现的位置。**
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int m = t.length(), n = s.length();
        //多一维度，便于统一边界处理
        int[][] f = new int[t.length()+1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m; //m表示找不到
        }
        //f[m][t.charAt(m-1)-'a'] = m-1;
        for(int i = m-1; i >= 0; i--){
            for(int j = 0; j < 26; j++){
                if(t.charAt(i) - 'a'== j){
                    f[i][j] = i;
                }else{
                    f[i][j] = f[i+1][j];
                }
            }
        }
        int next = 0;
        for (int i = 0; i < s.length(); i++) {
            if(f[next][s.charAt(i) - 'a'] == m){
                return false;
            }
            //下一次在匹配成功位置的下一个位置寻找
            next = f[next][s.charAt(i)-'a'] + 1;
        }
        return true;
    }

    /**
     * 暴力
     * 两个字符串都只由小写字符组成。
     */
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
                if (j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence392 isSubsequence392 = new IsSubsequence392();
        System.out.println(isSubsequence392.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence392.isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence392.isSubsequence("", "ahbgdc"));

    }
}
