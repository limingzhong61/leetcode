package lmz.algorithm.graph_parse_ds.find;

import lmz.my.leetcode.TransformUtil;

public class MissingNumber53II {
    /**
     * 二分查找:不等于条件
     * 找到不等的最小index；
     */
    public int missingNumber(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //不等，包含[low,mid]
            if (nums[mid] != mid) {
                high = mid;
            } else { //相等 ,不包含mid (mid,high]
                low = mid + 1;
            }
        }
        return low;
    }
    /**
     * 二分查找:等于条件
     * 找到不等的最小index；
     */
    public int missingNumber1(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //不等，包含[low,mid]
            if (nums[mid] != mid) {
                high = mid - 1;
            } else { //相等 ,不包含mid (mid,high]
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        MissingNumber53II missingNumber53II = new MissingNumber53II();

        System.out.println(missingNumber53II.missingNumber(TransformUtil.toIntArray("[0,1,3]")));
        System.out.println(missingNumber53II.missingNumber(TransformUtil.toIntArray("[0,1,3]")) == 2);

        System.out.println(missingNumber53II.missingNumber(TransformUtil.toIntArray("[0,1,2,3,4,5,6,7,9]")));
        System.out.println(missingNumber53II.missingNumber(TransformUtil.toIntArray("[0,1,2,3,4,5,6,7,9]")) == 8);

        System.out.println(missingNumber53II.missingNumber(TransformUtil.toIntArray("[0]")));
        System.out.println(missingNumber53II.missingNumber(TransformUtil.toIntArray("[0]")) == 1);

    }
}
