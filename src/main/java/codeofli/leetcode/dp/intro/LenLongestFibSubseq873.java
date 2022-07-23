package codeofli.leetcode.dp.intro;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq873 {
    /**
     * leetcode:dp
     * dp[j][i]表示以j,i结尾的序列长度
     */
    public int lenLongestFibSubseq(int[] arr) {
        //n >= 3
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int[][] dp =new int[n][n];
        int res = 0;
        // 因为i正向从0开始，则j逆向正向都行
        for (int i = 0; i < n; i++) {
            //由于数组 arr 是严格单调递增的，因此在确定下标i 的情况下可以反向遍历下标 j，
            // 计算 dp[j][i] 的值，只有当arr[j]×2>arr[i]
            // 时才满足  arr[k]<arr[j]，当 arr[j]×2≤arr[i] 时不需要对当前下标 i 继续遍历更小的下标 j。
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int diff = arr[i] - arr[j];
                int k = indexMap.getOrDefault(diff,-1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                res = Math.max(dp[j][i],res);
            }

        }
        return res;
    }

    /**
     * 两层for
     * 每次从A中找前两个数，然后查看后续符合斐波那契的数在A中有没有
     * 可以用HashMap记录<value,index>便于查找
     */
    public int lenLongestFibSubseq1(int[] arr) {
        //n >= 3
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int f1 = i;
                int f2 = j;
                int cnt = 2;
                while (f2 < n && indexMap.containsKey(arr[f1] + arr[f2])) {
                    int temp = f2;
                    f2 = indexMap.get(arr[f1] + arr[f2]);
                    f1 = temp;
                    cnt++;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
        }
        return maxCnt == 2 ? 0 : maxCnt;
    }

    public static void main(String[] args) {
        LenLongestFibSubseq873 lenLongestFibSubseq873 = new LenLongestFibSubseq873();
        testCase(lenLongestFibSubseq873, "[1,2,3,4,5,6,7,8]", 5);

        testCase(lenLongestFibSubseq873, " [1,3,7,11,12,14,18]", 3);
        testCase(lenLongestFibSubseq873, " [1,3,5]", 0);

    }

    private static void testCase(LenLongestFibSubseq873 lenLongestFibSubseq873, String s, int i) {
        System.out.println(lenLongestFibSubseq873.lenLongestFibSubseq(StringTransformUtil.toIntArray(s)));
        System.out.println(lenLongestFibSubseq873.lenLongestFibSubseq(StringTransformUtil.toIntArray(s)) == i);
    }
}
