package codeofli.leetcode.other.old.primary.arrays;

public class RemoveDuplicates26 {
    /**
     *双指针法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int j = 1; // j为标记不重复元素位置的指针（j=不重复元素个数-1,因为数组下标从0开始）
        //nums[0],此时只有一个，肯定不同。
        for(int i = 1; i < n; i++){
            if(nums[i-1] != nums[i]){
                nums[j] = nums[i];
                j++;
            }
        }
        return  j;
    }
}
