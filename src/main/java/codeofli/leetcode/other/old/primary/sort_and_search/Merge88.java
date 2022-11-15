package codeofli.leetcode.other.old.primary.sort_and_search;

import java.util.Arrays;

public class Merge88 {
    /**
     * my:
     * 归并排序
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] temps = Arrays.copyOf(nums1, m);
        //int minLength = Math.min(m,n);
        int index = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (temps[i] < nums2[j]) {
                nums1[index++] = temps[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[index++] = temps[i++];
        }
        while (j < n) {
            nums1[index++] = nums2[j++];
        }
    }

    /**
     * leetcode:
     * 逆向双指针---归并排序,因为num1后有n个空位
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //int minLength = Math.min(m,n);
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}
