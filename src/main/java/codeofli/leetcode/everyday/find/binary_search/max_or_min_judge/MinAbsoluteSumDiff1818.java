package codeofli.leetcode.everyday.find.binary_search.max_or_min_judge;

import codeofli.my.leetcode.TransformUtil;

import java.util.Arrays;

public class MinAbsoluteSumDiff1818 {
    /**
     * 二分查找
     * 只需要二分查找找到>=x的最小值下标idx，则和x绝对值最近的点就是min([idx],[idx-1]）（0<idx < n）
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] copy = Arrays.copyOf(nums1, n);
        Arrays.sort(copy);
        int maxGap = 0;
        int sum = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int biggerIndex = biggerNumberIndexByBS(copy, nums2[i]);
            if (biggerIndex < n) {
                maxGap = Math.max(maxGap, diff - (copy[biggerIndex] - nums2[i]));
            }
            if (biggerIndex > 0) {
                maxGap = Math.max(maxGap, diff - ( nums2[i] - copy[biggerIndex -1]));
            }
        }

        return (sum - maxGap + MOD) % MOD;
    }

    /**
     * 二分查找>= x的最小值。
     * F,T 右边界
     *
     * @return 返回值（arr.length）有可能比数组中所有数字都大
     */
    private int biggerNumberIndexByBS(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        MinAbsoluteSumDiff1818 minSpeedOnTime1870 = new MinAbsoluteSumDiff1818();
        testCase(minSpeedOnTime1870, "[150,100]", "[90,10]", 10);
        testCase(minSpeedOnTime1870, "[5,2,7]", "[10,7,12]", 10);
        testCase(minSpeedOnTime1870, "[1,10,4,4,2,7]", "[9,3,5,1,7,4]", 20);
        testCase(minSpeedOnTime1870, "[2,4,6,8,10]", "[2,4,6,8,10]", 0);
        testCase(minSpeedOnTime1870, "[53,48,14,71,31,55,6,80,28,19,15,40,7,21,69,15,5,42,86,15,11,54,44,62,9,100,2,26,81,87,87,18,45,29,46,100,20,87,49,86,14,74,74,52,52,60,8,25,21,96,7,90,91,42,32,34,55,20,66,36,64,67,44,51,4,46,25,57,84,23,10,84,99,33,51,28,59,88,50,41,59,69,59,65,78,50,78,50,39,91,44,78,90,83,55,5,74,96,77,46]",
                "[39,49,64,34,80,26,44,3,92,46,27,88,73,55,66,10,4,72,19,37,40,49,40,58,82,32,36,91,62,21,68,65,66,55,44,24,78,56,12,79,38,53,36,90,40,73,92,14,73,89,28,53,52,46,84,47,51,31,53,22,24,14,83,75,97,87,66,42,45,98,29,82,41,36,57,95,100,2,71,34,43,50,66,52,6,43,94,71,93,61,28,84,7,79,23,48,39,27,48,79]",
                3156);
    }

    private static void testCase(MinAbsoluteSumDiff1818 minSpeedOnTime1870, String original, String original1, int x) {
        System.out.println(minSpeedOnTime1870.minAbsoluteSumDiff(TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1)));
        System.out.println(minSpeedOnTime1870.minAbsoluteSumDiff(TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1)) == x);
    }
}
