package exam.old.tc.t2;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * minDays
     *
     * @param n int整型
     * @return int整型
     */
    public int minDays(int n) {
        if (n == 1) return 1;
        // write code here
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            if (i % 2 == 0) {
                int minus = i / 2;
                f[i] = Math.min(f[i - minus] + 1, f[i]);
            }
            if (i % 3 == 0) {
                int minus = i / 3 * 2;
                f[i] = Math.min(f[i - minus] + 1, f[i]);
            }
            for (int j = 0; j < i; j++) {
                f[i] = Math.min(f[j] + i - j, f[i]);
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDays(6));
    }
}
