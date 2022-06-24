package codeofli.my.solution_template.find;

public class BSFindDividedPoint {
    /**
     * my二叉搜索：返回小于target的个数
     * [<target](目标index)[>=target]
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0,high = nums.length -1;
        while (low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] < target){
                low =mid+1;
            }else {
                high = mid-1;
            }
        }
        return low;
    }


    /**
     * leetcode:找到左右边界，相减即可
     */
    public int search(int[] nums, int target) {
        int leftIndex = binarySearchFindSmallerCnt(nums,target-1);
        int rightIndex = binarySearchFindSmallerCnt(nums,target);
        return rightIndex-leftIndex;
    }

    /**
     * 找到插入target的最大位置，即小于等于target的个数
     * 本质上看，函数旨在查找数字 tartar 在数组 nums中的 插入点 ，
     * 且若数组中存在值相同的元素，则插入到这些元素的右边。
     */
    private int binarySearchFindSmallerCnt(int[] nums, int target) {
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
}
