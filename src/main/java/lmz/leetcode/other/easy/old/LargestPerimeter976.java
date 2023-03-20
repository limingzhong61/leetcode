package lmz.leetcode.other.easy.old;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;

public class LargestPerimeter976 {
    /**
     * 排序+贪心
     * leetcode:先对整个数组排序，倒序枚举第 i 个数作为最长边，那么我们只要看其前两个数 A[i−2]
     * 和 A[i−1]，判断 A[i−2]+A[i−1] 是否大于 A[i] 即可，如果能组成三角形我们就找到了最大周长的三角形，返回答案A[i−2]+A[i−1]+A[i] 即可。
     * **为什么只需要判断数组中相邻的三个数？**
     * 在固定最后一个数 A[i] 时，前两个数需不需要再往前找呢？
     * 如果 A[i-2] + A[i-1] <= A[i] ，这三个数一定不能构成三角形，而A[i-3]以及更往前的数，都小于等于A[i-2]，所以再往前取任何两个数只会让相加的值更小，就更不能满足 A[j] + A[k] > A[i]了 (j<i-2, k<i-1, j<k)。所以如果相邻的数构不成三角形，就不需要再固定第三个数并往前找两个数了。
     * 如果 A[i-2] + A[i-1] > A[i]j，这三个数可以构成三角形，再往前找只会让周长变短，所以也不用再往前了。
     * 综上，只需要判断相邻的三个数。
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

    public int largestPerimeter1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 3, j = n - 2, k = n - 1; i >= 0; ) {
            if (nums[i] + nums[j] > nums[k]) {
                return nums[i] + nums[j] + nums[k];
            } else {
                k--;
                if (k == j) {
                    j--;
                }
                if (j == i) {
                    i--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeter976 largestPerimeter = new LargestPerimeter976();

        testCase(largestPerimeter, "[2,1,2]", 5);
        testCase(largestPerimeter, "[1,2,1]", 0);
        testCase(largestPerimeter, "[1,2,3,4,5,6,7,8,17]", 0);
    }

    private static void testCase(LargestPerimeter976 largestPerimeter, String s, int i) {
        System.out.println(largestPerimeter.largestPerimeter(TransformUtil.toIntArray(s)));
        System.out.println(largestPerimeter.largestPerimeter(TransformUtil.toIntArray(s)) == i);
    }

}
