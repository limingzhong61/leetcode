package com.lmz.algorithm_practice.dp.digit_dp;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-03-20 8:30
 */
public class NumDupDigitsAtMostN1012 {
    class Solution {
        /**
         * 正难则反，转换成求无重复数字的个数。
         * 记忆化搜索
         * https://leetcode.cn/problems/numbers-with-repeated-digits/solutions/1748539/by-endlesscheng-c5vg/
         */
        char s[];
        int dp[][];

        public int numDupDigitsAtMostN(int n) {
            s = Integer.toString(n).toCharArray();
            int m = s.length;
            dp = new int[m][1 << 10];
            for (int i = 0; i < m; i++)
                Arrays.fill(dp[i], -1); // -1 表示没有计算过
            return n - f(0, 0, true, false);
        }

        /**
         * 将 n 转换成字符串 s，定义 f(i,mask,isLimit,isNum) 表示构造从高到低第 i 位及其之后数位的合法方案数
         *
         * @param i       枚举的位数
         * @param mask    mask 表示前面选过的数字集合，换句话说，第 i 位要选的数字不能在  mask 中。
         * @param isLimit isLimit 表示当前是否受到了 n 的约束。若为真，则第 i 位填入的数字至多为 s[i] ，否则可以是 9 。
         *                如果在受到约束的情况下填了 s[i] ，那么后续填入的数字仍会受到 n 的约束。
         *                当isLimit为true表示前面的字母都是符合n的最高位
         * @param isNum   isNum 表示 i 前面的数位是否填了数字。若为假，则当前位可以跳过（不填数字），或者要填入的数字至少为 1 ；
         *                若为真，则要填入的数字可以从 0开始。
         * @return
         */
        private int f(int i, int mask, boolean isLimit, boolean isNum) {
            if (i == s.length) { // 枚举结束
                return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
            }
            if (!isLimit && isNum && dp[i][mask] != -1) // 已经记忆化了
                return dp[i][mask];
            int res = 0;
            if (!isNum) { //没有枚举过数字
                res = f(i + 1, mask, false, false);
            }
            int up = isLimit ? s[i] - '0' : 9;  // 枚举上界
            for (int d = isNum ? 0 : 1; d <= up; d++) {
                if ((mask >> d & 1) == 0) { // 没有包含d
                    // 当isLimit为true表示前面的字母都是符合n的最高位
                    res += f(i + 1, mask | (1 << d), isLimit && d == up, true); // 枚举了数字isNum=true;
                }
            }
            if (!isLimit && isNum) {
                dp[i][mask] = res;
            }
            return res;
        }
    }

    /**
     * 正难则反，转换成求无重复数字的个数。
     * 记忆化搜索
     * https://leetcode.cn/problems/numbers-with-repeated-digits/solutions/1748539/by-endlesscheng-c5vg/
     */
    char s[];
    int dp[][];

    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][1 << 10];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1); // -1 表示没有计算过
        return n - f(0, 0, true, false);
    }

    /**
     * 将 n 转换成字符串 s，定义 f(i,mask,isLimit,isNum) 表示构造从高到低第 i 位及其之后数位的合法方案数
     *
     * @param i       枚举的位数
     * @param mask    mask 表示前面选过的数字集合，换句话说，第 i 位要选的数字不能在  mask 中。
     * @param isLimit isLimit 表示当前是否受到了 n 的约束。若为真，则第 i 位填入的数字至多为 s[i] ，否则可以是 9 。
     *                如果在受到约束的情况下填了 s[i] ，那么后续填入的数字仍会受到 n 的约束。
     * @param isNum   isNum 表示 i 前面的数位是否填了数字。若为假，则当前位可以跳过（不填数字），或者要填入的数字至少为 1 ；
     *                若为真，则要填入的数字可以从 0开始。
     * @return
     */
    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length)
            return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
        if (!isLimit && isNum && dp[i][mask] != -1)
            return dp[i][mask];
        int res = 0;
        if (!isNum) // 可以跳过当前数位
            res = f(i + 1, mask, false, false);
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
        for (int d = isNum ? 0 : 1; d <= up; ++d) // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) // d 不在 mask 中
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
        if (!isLimit && isNum)
            dp[i][mask] = res;
        return res;
    }
}
