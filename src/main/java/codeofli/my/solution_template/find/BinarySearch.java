package codeofli.my.solution_template.find;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找>= x的最小值。
     * F,T 右边界
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

    /**
     * 二分查找<= x的最大值。
     *T, F,左边界
     */
    private int smallerNumberIndexByBS(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else { //此时 <= x
                pos = mid;
                low = mid + 1;
            }
        }
        if (pos == -1) { //有可能比数组中所有数字都小
            return 0;
        }
        return pos;
    }
}
