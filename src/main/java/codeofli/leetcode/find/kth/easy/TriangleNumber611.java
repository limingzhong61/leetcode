package codeofli.leetcode.find.kth.easy;

import java.util.Arrays;

public class TriangleNumber611 {
    /**
     * 枚举a然后双指针b,c
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        //1 <= nums.length <= 1000
        if (n < 3) {
            return 0;
        }
        int cnt = 0;
        Arrays.sort(nums);
        for (int a = 0; a < n; a++) {
            int c = a;
            for (int b = a + 1; b < n; ++b) {
                while (c + 1 < n && nums[c + 1] < nums[a] + nums[b]) {
                    ++c;
                }
                cnt += Math.max(c - b, 0);
            }
        }
        return cnt;
    }

    /**
     * 枚举a,b然后二分查找c n^2logn
     */
    public int triangleNumber2(int[] nums) {
        int n = nums.length;
        //1 <= nums.length <= 1000
        if (n < 3) {
            return 0;
        }
        int cnt = 0;
        Arrays.sort(nums);
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                int nextC = nums[a] + nums[b];
                //<,>= 左边界
                int low = b + 1, high = n - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (nums[mid] < nextC) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                cnt += high - b;
            }
        }
        return cnt;
    }

    /**
     * 暴力 n^3
     */
    public int triangleNumber1(int[] nums) {
        int n = nums.length;
        //1 <= nums.length <= 1000
        if (n < 3) {
            return 0;
        }
        int cnt = 0;
        Arrays.sort(nums);
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                int nextC = nums[a] + nums[b];
                for (int c = b + 1; c < n && nums[c] < nextC; c++) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
