package test.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.*;

/**
 * 字节面试题：
 * 字节面试题，求大佬们看看，数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。
 * 例如A={1, 2, 4, 9}，x=2533，返回2499
 * <p>
 * 回溯一下就好了啊，对每一位先尝试使用相同数字，直到最后一位或者没有相同的数字时，尝试是否有比当前数字更小的，
 * 有的话选更小的数字里最大的，剩下的用最大数字；都没有就向前回溯看前一个有没有更小的。如果一直回溯到第一个数字，就用位数更少的全都是最大数字的数。
 * <p>
 * <p>
 * <p>
 * https://leetcode.cn/circle/discuss/fbhhev/
 */
public class Nmin {
    /**
     * 分情况讨论：每次尝试填充nums[] 中的第p 到ans[]中
     *
     *  1. 不存在 符合 <= nums[p]的值
     *   则每次减少p的idx，
     *   1.1 如果存在 小于 arr[idx] < ans[p] ,则  添加该arr[idx]，且后续的p填充为arr[]中的最大值
     *   p++,后续继续填充，到步骤1
     *   1.2 如果p==0 时 任然找不到，则，直接用 arr[]中的最大值 组成 n-1个数 ，return
     *
     *  2.存在 符合 <= nums[p]的值
     *   2.1 如果存在 = nums[p]的继续填充,p++
     *   2.2 只存在 arr[idx] < num[p]的，则 添加该arr[idx]，且后续的p填充为arr[]中的最大值 ，return
     */
    int nMim(int[] arr, int target) {
        // 获取target对应的数组
        char[] cs = String.valueOf(target).toCharArray();
        int[] nums = new int[cs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cs[i] - '0';
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int p = 0, arrLen = arr.length;
        for (; p < nums.length; p++) {
            // arr[]中所有的数都比nums[p]大

            // 不存在 符合 <= nums[p]的值
            if (arr[0] > nums[p]) {
                // 从后往前,看能否找到一个比已经选择的数更小的值
                while (!stack.isEmpty()) {
                    int lastVal = stack.pollLast();
                    p--;
                    // 不存在,更小的值
                    if (arr[0] >= lastVal) {
                        continue;
                    }
                    int idx = 0;
                    while (idx < arr.length && arr[idx + 1] < lastVal) idx++;
                    stack.add(arr[idx]);
                    // 找到了
                    // 后面添加最大的数
                    for (int i = p + 1; i < nums.length; i++) {
                        stack.addLast(arr[arrLen - 1]);
                    }
                    return toNum(stack);
                }

                if (p == 0) {
                    // 直接剩余位数-1 都去取值arr中的最大值 arr[arrLen-1]
                    // 后面数字取最大值
                    for (int i = p + 1; i < nums.length; i++) {
                        stack.add(arr[arrLen - 1]);
                    }
                    return toNum(stack);
                }
            }

            // 从 arr[]中找到小于等于nums[p]的最大值，一定存在
            int idx = findMaxIdxInSmallerEqual(arr, nums[p]);


            // arr[]中所有的数都比nums[p]小，
            // 则p及其以后的数字都由最大的arr[arr.length-1]组成
            if (idx >= arrLen) {
                for (; p < nums.length; p++) {
                    stack.addFirst(p);
                }
                return toNum(stack);
            }
            // arr[idx] <= nums[p]
            if (arr[idx] == nums[p]) { //相等继续，前移
                stack.addLast(arr[idx]);
                continue;
            }
            // arr[idx-1] < nums[p]
            stack.add(arr[idx]);
            // 后面数字取最大值
            for (int i = p + 1; i < nums.length; i++) {
                stack.addLast(arr[arrLen - 1]);
            }
            return toNum(stack);

        }
        return -1;
    }

    /**
     * 在有序数组中找到<= target 的最大值的idx
     *
     * @param nums   升序数组
     * @param target
     * @return idx
     */
    int findMaxIdxInSmallerEqual(int[] nums, int target) {
        // 最小值
        if (target < nums[0]) return -1;
        // 经过判断 nums[0] <= target
        int idx = 0;
        while (idx + 1 < nums.length && nums[idx + 1] <= target) idx++;
        return idx;
    }


    private int toNum(Deque<Integer> q) {
        int ans = 0;
        while (!q.isEmpty()) {
            ans = ans * 10 + q.pollFirst();
        }
        return ans;
    }


    public static void main(String[] args) {
        Nmin nmin = new Nmin();
        testCase(nmin, "[2,4,5]", 24132, 22555);

        testCase(nmin, "[2,3,5]", 3211, 2555);


        testCase(nmin, "[1,2,4,9]", 2533, 2499);
        testCase(nmin, "[7,8]", 111, 88);
    }

    private static void testCase(Nmin nmin, String original, int target, int x) {
        System.out.println(nmin.nMim(TransformUtil.toIntArray(original), target));
        System.out.println(nmin.nMim(TransformUtil.toIntArray(original), target) == x);
    }


}