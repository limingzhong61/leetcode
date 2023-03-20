package lmz.leetcode.other.old.everyday.sort;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;

public class WiggleSort324 {
    /**
     * 先排序，后双指针，left在中间开始，right从最后开始一起向左移动，
     * 这样就有移动的高度差
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length - 1,left = right/2;
        int[] temp = Arrays.copyOf(nums,nums.length);
        for(int i = 0; i < nums.length; i++){
            nums[i] = i % 2 == 0 ? temp[left--] :  temp[right--];
        }
    }
    /**
     * 先排序，后双指针，left在中间开始，right从最后开始一起向左移动，
     * 这样就有移动的高度差
     */
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length - 1,left = right/2;
        int[] res = Arrays.copyOf(nums,nums.length);
        int index = 0;
        while(left >= 0){
            nums[index++] = res[left--];
            if(index < nums.length){ //[left+1,right]一截在数组长度为奇数时，比[0,left]少一个
                nums[index++] = res[right--];
            }

        }
    }

    public static void main(String[] args) {
        WiggleSort324 wiggleSort324 = new WiggleSort324();

        testCase(wiggleSort324, "[1,5,1,1,6,4]");

        testCase(wiggleSort324, "[1,3,2,2,3,1]");
        testCase(wiggleSort324, "[1,2,3,4,5]");
    }

    private static void testCase(WiggleSort324 wiggleSort324, String s) {
        int[] nums1 = TransformUtil.toIntArray(s);
        wiggleSort324.wiggleSort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
