package codeofli.leetcode.graph_parse_ds.find;

import codeofli.my.leetcode.StringTransformUtil;

public class Search53 {
    /**
     * leetcode:找到左右边界，相减即可
     */
    public int search(int[] nums, int target) {
        int leftIndex = binarySearchRightBound(nums,target-1);
        int rightIndex = binarySearchRightBound(nums,target);
        return rightIndex-leftIndex;
    }

    /**
     * 找到插入target的最大位置，即小于等于target的个数
     * 本质上看，函数旨在查找数字 tartar 在数组 nums中的 插入点 ，
     * 且若数组中存在值相同的元素，则插入到这些元素的右边。
     */
    private int binarySearchRightBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //查找右边界right ，包含相等时则执行low=m+1 ；（跳出时i指向右边界）
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * my:二分查找，找到后然后线性扫描
     */
    public int search1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                int left = mid, right = mid;
                while (left > 0 && nums[left-1] == target) left--;
                while (right < nums.length - 1 && nums[right+1] == target) right++;
                return right - left + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Search53 search53 = new Search53();

        //System.out.println(search53.search(TransformString.toIntArray(" [5,7,7,8,8,10]"), 8));
        //System.out.println(search53.search(TransformString.toIntArray(" [5,7,7,8,8,10]"), 8) == 2);

        System.out.println(search53.search(StringTransformUtil.toIntArray(" [8,8]"), 8));
        System.out.println(search53.search(StringTransformUtil.toIntArray(" [8,8]"), 8) == 2);

        System.out.println(search53.search(StringTransformUtil.toIntArray("[1]"), 1));
        System.out.println(search53.search(StringTransformUtil.toIntArray("[1]"), 1) == 1);

        System.out.println(search53.search(StringTransformUtil.toIntArray("[2,2]"), 2));
        System.out.println(search53.search(StringTransformUtil.toIntArray("[2,2]"), 2) == 2);
    }
}
