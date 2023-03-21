package lmz.leetcode.dp.hard;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class MaxChunksToSorted768 {
    /**
     * 单调栈
     * 拆入+维护块的最大值
     * 记录每一个块的最大值，如果插入值能大于一个块的最大值，则能融入该块。这该块和其后所有的块形成一个新的块。
     */
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for (int j : arr) {
            if (stack.isEmpty() || j >= stack.peek()) {
                stack.push(j);
            } else {
                int maxTop = stack.peek();
                while (!stack.isEmpty() && j < stack.peek()) { // arr[i]小于，则需要与前一块合并
                    stack.poll();
                }
                stack.push(maxTop);
            }
        }
        return stack.size();
    }

    /**
     * 排序 + 哈希表
     * 如果一个数组能分为两块，那么一定能找到一个下标 k，
     * 这个下标将数组分为两个非空子数组 arr[0,…,k] 和 arr[k+1,…,n−1]，
     * 使得 arr[0,…,k] 和 sortedArr[0,…,k] 的元素频次相同，
     * arr[k+1,…,n−1] 和 sortedArr[k+1,…,n−1] 的元素频次相同
     */
    public int maxChunksToSorted2(int[] arr) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
            if (cntMap.get(x) == 0) {
                cntMap.remove(x);
            }
            cntMap.put(y, cntMap.getOrDefault(y, 0) - 1);
            if (cntMap.get(y) == 0) {
                cntMap.remove(y);
            }
            if (cntMap.isEmpty()) {
                res++;
            }
        }
        return res;
    }

    /**
     * N^3 超出时间限制了
     * 设f[i][j]为最多可分的块
     * f[i][j] = max(f[i][k] +  f[k+1][j] + 1,f[i][j]) if {max(arr[i..k]) <= min(arr[k+1,j], i <= k < j}
     */
    public int maxChunksToSorted1(int[] arr) {
        //arr的长度在[1, 2000]之间。
        int n = arr.length;
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
            min[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                max[i][j] = Math.max(max[i][j - 1], arr[j]);
                min[i][j] = Math.min(min[i][j - 1], arr[j]);
            }
        }
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], 1);  //所有arr[i...j]经过一个排序后都能为升序。
            // f[i][i] = 1; //1个数最多分成1块
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    if (max[i][k] <= min[k + 1][j]) {
                        f[i][j] = Math.max(f[i][j], f[i][k] + f[k + 1][j]);
                    }
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        MaxChunksToSorted768 maxChunksToSorted768 = new MaxChunksToSorted768();
        testCase(maxChunksToSorted768, "[0,0,1,1,1]", 5);
        testCase(maxChunksToSorted768, "[1,0,1,3,2]", 3);
    }

    private static void testCase(MaxChunksToSorted768 maxChunksToSorted768, String original, int x) {
        System.out.println(maxChunksToSorted768.maxChunksToSorted(TransformUtil.toIntArray(original)));
        System.out.println(maxChunksToSorted768.maxChunksToSorted(TransformUtil.toIntArray(original)) == x);
    }
}
