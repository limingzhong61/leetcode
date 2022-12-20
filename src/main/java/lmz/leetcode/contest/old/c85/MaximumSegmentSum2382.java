package lmz.leetcode.contest.old.c85;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class MaximumSegmentSum2382 {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        //1 <= n <= 10^5
        int n = nums.length;
        // 求前缀和，方便我们直接求出区间的和
        //sum[i] == sum(nums[0...i-1])
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        // 放入下标 -1 和 n，这样就无需处理边界情况
        treeSet.add(-1);
        treeSet.add(n);
        //因为可能有重复元素，故用TreeMap
        //<sum,cnt>
        TreeMap<Long, Integer> sumMap = new TreeMap<>();
        // 一开始只有一个子段和，也就是整个数组之和
        sumMap.put(sum[n], 1);
        long[] res = new long[n];
        int index = 0;
        for (int rmPos : removeQueries) {
            // 找出第一个比 rmPos 大的已删除下标 R-1，以及最后一个比 rmPos 小的已删除下标 L+1
            int upBound = treeSet.higher(rmPos) - 1;
            int lowerBound = treeSet.lower(rmPos) + 1;
            // 删除 rmPos，把它也放入 st 中
            treeSet.add(rmPos);
            long rangeSum = sum[upBound + 1] - sum[lowerBound];
            if (sumMap.get(rangeSum) == 1) {
                sumMap.remove(rangeSum);
            }else{
                sumMap.put(rangeSum,sumMap.get(rangeSum)-1);
            }
            if (rmPos + 1 <= upBound) { // [rmPos+1, upBound]
                long leftSum = sum[upBound + 1] - sum[rmPos + 1];
                sumMap.put(leftSum, sumMap.getOrDefault(leftSum, 0) + 1);
            }
            if (lowerBound <= rmPos - 1) { // [lower, rmPos - 1]
                long rightSum = sum[rmPos] - sum[lowerBound];
                sumMap.put(rightSum, sumMap.getOrDefault(rightSum, 0) + 1);
            }
            // 求出最大的子段和
            if (sumMap.isEmpty()) {
                res[index++] = 0;
            } else {
                res[index++] = sumMap.lastKey();
            }
        }
        return res;
    }


    public static void main(String[] args) {
        MaximumSegmentSum2382 maximumSegmentSum2382 = new MaximumSegmentSum2382();
        System.out.println(Arrays.toString(maximumSegmentSum2382.maximumSegmentSum(TransformUtil.toIntArray("[1,2,5,6,1]"),
                TransformUtil.toIntArray("[0,3,2,4,1]"))));
        System.out.println(Arrays.equals(maximumSegmentSum2382.maximumSegmentSum(
                        TransformUtil.toIntArray("[1,2,5,6,1]"), TransformUtil.toIntArray("[0,3,2,4,1]")),
                TransformUtil.toLongArray("[14,7,2,2,0]")));

        System.out.println(Arrays.toString(maximumSegmentSum2382.maximumSegmentSum(TransformUtil.toIntArray("[1,2,3,4,5]"),
                TransformUtil.toIntArray("[3,0,4,2,1]"))));
        System.out.println(Arrays.equals(maximumSegmentSum2382.maximumSegmentSum(
                        TransformUtil.toIntArray("[1,2,3,4,5]"), TransformUtil.toIntArray("[3,0,4,2,1]")),
                TransformUtil.toLongArray("[6,5,5,2,0]")));
    }
}
