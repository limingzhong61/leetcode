package lmz.algorithm.dp;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

public class FindLongestChain646 {
    /**
     * 利用最长递增子序列的思想
     * 用f[i]表示链长度为i时，最小的右边界值，len表示当前最长链长度；
     * 当求f[i+1]的链长度时能用二分查找，找到更小右边界的值。
     */
    public int findLongestChain(int[][] pairs) {
        //按照第一个元素升序
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] f = new int[n + 1];
        f[1] = pairs[0][1];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > f[len]) {
                f[++len] = pairs[i][1];
            } else {
                int low = 0, high = len, pos = 0;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (f[mid] >= pairs[i][0]) {
                        high = mid - 1;
                    } else {
                        pos = mid;
                        low = mid + 1;
                    }
                    f[pos + 1] = Math.min( pairs[i][1],f[pos+1]);
                }
            }
        }
        return len;
    }

    /**
     * f[i]表示第i个数对的链的长度
     * 给出数对的个数在 [1, 1000] 范围内。
     */
    public int findLongestChain1(int[][] pairs) {
        //按照第一个元素升序
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        FindLongestChain646 findLongestChain646 = new FindLongestChain646();
        //testCase(findLongestChain646, "[[-3,9],[-5,0],[6,7],[2,6],[-9,-3],[-5,-3],[-7,7],[-2,10],[7,8],[-1,10]]", 3);
        testCase(findLongestChain646, "[[5,7],[-8,2],[-3,7],[-8,9],[-2,1],[-8,-5],[-2,-1],[2,4],[2,6]]", 4);
    }

    private static void testCase(FindLongestChain646 findLongestChain646, String original, int x) {
        System.out.println(findLongestChain646.findLongestChain(TransformUtil.toIntMatrix(
                original)));
        System.out.println(findLongestChain646.findLongestChain(TransformUtil.toIntMatrix(
                original)) == x);
    }
}
