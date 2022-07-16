package codeofli.leetcode.dp.intro;

public class NumDecodings91 {
    /**
     * f[i]表示[0,i]能有多少种解码
     * f[i] = f[i-1]+f[i-2] if 0<= s[i-1]*10+s[i] <= 26
     * 滚动数组优化
     */
    public int numDecodings(String s) {
        //1 <= s.length <= 100
        int len = s.length();
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int[] f = new int[len];
        f[0] = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') {
                //s 只包含数字，并且可能包含前导零。
                if (chars[i-1] > '2' || chars[i-1] == '0') { //xx30xx,xx40xx,xx00xx
                    return 0;
                } else { // xx10xx,xx20xx; f = f
                    f[i] = f[i - 1];
                    continue;
                }
            }
            // 10,20, 102,201只有一种情况
            if (chars[i] != '0' && chars[i - 1] != '0' && (chars[i - 1] - '0') * 10 + (chars[i] - '0') <= 26) {
                if(i+ 1 < len && chars[i+1] == '0'){
                    f[i] = f[i-1];
                    continue;
                }
                f[i] = f[i - 1];
                if (i - 2 >= 0)
                   f[i]  += f[i - 2];
                else
                    f[i]++;
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[len - 1];
    }

    public static void main(String[] args) {
        NumDecodings91 numDecodings91 = new NumDecodings91();
        testCase(numDecodings91, "12", 2);
        testCase(numDecodings91, "226", 3);
        testCase(numDecodings91, "0", 0);
        testCase(numDecodings91, "012", 0);
        testCase(numDecodings91, "10", 1);
        testCase(numDecodings91, "93", 1);
        testCase(numDecodings91, "102", 1);
        testCase(numDecodings91, "2101", 1);
        testCase(numDecodings91, "1123", 5);
        testCase(numDecodings91, "10011", 0);
        testCase(numDecodings91, "301", 0);
        //System.out.println((char) (11 + 'A'));
    }

    private static void testCase(NumDecodings91 numDecodings91, String s, int i) {
        System.out.println(numDecodings91.numDecodings(s));
        System.out.println(numDecodings91.numDecodings(s) == i);
    }
}
