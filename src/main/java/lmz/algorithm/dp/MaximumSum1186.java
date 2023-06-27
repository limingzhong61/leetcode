package lmz.algorithm.dp;

/**
 * @author: limingzhong
 * @create: 2023-06-27 9:30
 */
public class MaximumSum1186 {
    /**
     * // dp[i][0]表示前i个元素, 删了0次, 考虑在第i个位置结尾, 能获得的最大和
     *     // dp[i][0]表示前i个元素, 删了1次, 考虑在第i个位置结尾, 能获得的最大和
     *     // 有个注意的点: 考虑在第i个位置结尾, 并不表示一定要选第i个元素以它结尾
     *
     *     f(0)= arr[0] //因为必须要有元素，不能为 0 个元素
     *     g(0) = 什么呢？
     *
         * 举个例子，假设我们要计算g(1)：
         *
         * g(1) = Math.max(g(0)+arr[1],f(0))//题目提到至少保留一个元素，所以必须要选f(0)，即g(0)要足够小
         * // g(0) + arr[1] < arr[0]
         * // g(0) < arr[0] - arr[1]
         * // 因为 - 10^4 <= arr[i] <= 10^4，所以arr[0]-arr[1] >= -2 * 10^4，即g(0)取-20001即可
     */
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] f = new int[n+1];
        int[] f2 = new int[n+1];
        f[0] = arr[0];
        f2[0] = -200001;
        int ans = arr[0];
        for(int i = 1; i < n; i++){
            f[i] = Math.max(f[i-1] + arr[i],arr[i]);
            f2[i] =Math.max(f[i-1],f2[i-1] + arr[i]);
            ans = Math.max(f[i],Math.max(ans,f2[i]));
        }
        return ans;
    }
}
