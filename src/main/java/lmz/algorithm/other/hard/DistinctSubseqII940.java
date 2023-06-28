package lmz.algorithm.other.hard;

import java.util.Arrays;

public class DistinctSubseqII940 {

    /**
     * dp:f[i][j]表示s 的前 i 个字符组成以 j 结尾的不同非空子序列的个数
     * 则f[0][i] = 1
     * f[i][j] = f[i-1][k] ( k从0到25）
     */
    public int distinctSubseqII1(String s) {
        int n = s.length();
        var cs = s.toCharArray();
        var f = new long[n][26];
        f[0][s.charAt(0) - 'a'] = 1;
        final long MOD = (long) 1e9 + 7;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1].clone();
            f[i][s.charAt(i) - 'a'] = (1 + Arrays.stream(f[i - 1]).sum()) % MOD;
        }
        return (int) (Arrays.stream(f[n - 1]).sum() % MOD);
    }

    /**
     * dp:f[i][j]表示s 的前 i 个字符组成以 j 结尾的不同非空子序列的个数
     * 则f[0][i] = 1
     * f[i][j] = f[i-1][k] ( k从0到25）
     * 空间优化： 只用了f[i-1],一维数组即可
     * 时间优化，每次只有[s.charAt(i) - 'a']位置发生来变化
     */
    public int distinctSubseqII(String s) {
        int n = s.length();
        var cs = s.toCharArray();
        var f = new long[26];
        long total = 0;
        total = f[s.charAt(0) - 'a'] = 1;
        final long MOD = (long) 1e9 + 7;
        for (int i = 1; i < n; i++) {
            long temp = total - f[s.charAt(i) - 'a'];
            f[s.charAt(i) - 'a'] = (1 + total) % MOD;
            total = temp + f[s.charAt(i) - 'a'];
        }
        return (int) (Arrays.stream(f).sum() % MOD);
    }

    public static void main(String[] args) {
        DistinctSubseqII940 distinctSubseqII940 = new DistinctSubseqII940();
        System.out.println(distinctSubseqII940.distinctSubseqII("aba"));
    }
}
