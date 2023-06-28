package lmz.util.solution_template.arrays;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-06-24 13:28
 */
public class ArraysUtil {
    /**
     * 数组中的第K个最大元素
     * 基于快速排序的选择方法
     * @param nums
     * @param k  数组中的第K个最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        // 第k大等于下标为 数组长度n - k
        return partition(nums, nums.length - k, 0, nums.length - 1);
    }

    private int partition(int[] nums, int loc, int low, int high) {
        int pivot = low;
        int preLow = low, preHigh = high;
        while (low < high) {
            while (low < high && nums[high] >= nums[pivot]) {
                high--;
            }
            while (low < high && nums[low] <= nums[pivot]) {
                low++;
            }
            swap(nums, low, high);
        }
        // 交换数轴处的数和分界点位置的数（left为分界点），因为本身就是以nums[pivot]分界的
        swap(nums, pivot, low);
        if (low == loc) {
            return nums[low];
        } else if (low > loc) {
            return partition(nums, loc, preLow, low - 1);
        } else {
            return partition(nums, loc, low + 1, preHigh);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    /**
     * 根据传入的数组生成一个前缀和数组
     * @param nums
     * @return
     */
    public  static  int[] getPrefixSumArray(int[] nums){
        if (nums.length == 0) {
            return null;
        }
        int[] sums = new int[nums.length + 1];
        sums[1] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return sums;
    }
}
