package lmz.leetcode.dp.two_dimension;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-03-31 16:30
 */
public class LenLongestFibSubseqII093 {
    /**
     * dp
     * 斐波拉契数列中的后两位能唯一确定一个序列。
     * f[i][j] 表示 以j,i结尾的斐波拉契数列最大长度
     * <p>
     * 利用数组 arr 的单调性优化
     * Arr递增，反向遍历j,得到的 arr[k] = arr[i]-arr[j] < arr[j] ,k存在则一定有 k < j
     *arr[k] < arr[j] -->  arr[i] - arr[j] < arr[j] --> arr[i] < 2* arr[j] --> 2 * arr[j] >= arr[i]时arr[k] > arr[j]
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        var f = new int[n][n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i] - arr[j] > arr[j]) break; // arr[j] 太小了
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k > -1) {
                    f[i][j] = Math.max(f[j][k] + 1, 3);
                }
                maxLen = Math.max(maxLen, f[i][j]);
            }
        }
        return maxLen;
    }

    /**
     * dp
     * 斐波拉契数列中的后两位能唯一确定一个序列。
     * f[i][j] 表示 以j,i结尾的斐波拉契数列最大长度
     */
    public int lenLongestFibSubseq1(int[] arr) {
        int n = arr.length;
        var f = new int[n][n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k > -1 && k < j) {
                    f[i][j] = Math.max(f[j][k] + 1, 3);
                }
                maxLen = Math.max(maxLen, f[i][j]);
            }
        }
        return maxLen;
    }
}
