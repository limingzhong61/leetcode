package lmz.my.solution_template.find;

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
     * 二分查找>= x的最小值下标。
     * F,T 右边界
     * @return 返回的index有越界检查，不会越界
     */
    private int biggerNumberIndexByBS(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low == arr.length) { //有可能比数组中所有数字都小
            return low - 1;
        }
        return low;
    }

    /**
     * 二分查找> x的最小值下标。
     * F,T 右边界[....,<=,>,.....]
     * @return 返回的index有越界检查，不会越界
     */
    public static int greaterNumberIndexByBS(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low == arr.length) { //有可能比数组中所有数字都大
            return low - 1;
        }
        return low;
    }

    /**
     * 二分查找<= x的最大值下标，。
     *T, F,左边界
     * @Return 返回的index有越界检查，不会越界
     */
    private int smallerNumberIndexByBS(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else { //此时 <= key
                pos = mid;
                low = mid + 1;
            }
        }
        if (pos == -1) { //有可能比数组中所有数字都小
            return 0;
        }
        return pos;
    }

    /**
     * 二分查找<= x的最大值下标，。
     *T, F,左边界
     */
    private int smallerNumberIndexByBS(int[] arr, int key, int fromIndex, int toIndex) {
        int low = fromIndex, high = toIndex - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else { //此时 <= key
                pos = mid;
                low = mid + 1;
            }
        }
        if (pos == -1) { //有可能比数组中所有数字都小
            return 0;
        }
        return pos;
    }
    /**
     * 二分查找<= x的最大值下标，。
     *T, F,左边界
     */
    private int smallerNumberIndexByBS(int[] arr, int key, int fromIndex) {
        int low = fromIndex, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else { //此时 <= key
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
