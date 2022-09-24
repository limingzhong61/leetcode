package codeofli.leetcode.other.easy;

public class MaxDistance1855 {
    /**
     * 二分查找
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        for (int i = 0; i < nums1.length; i++) {
            int low = 0, high = nums2.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums2[mid] > nums1[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int dist = high - i;
            maxDist = Math.max(maxDist,dist);
        }
        return maxDist;
    }
}
