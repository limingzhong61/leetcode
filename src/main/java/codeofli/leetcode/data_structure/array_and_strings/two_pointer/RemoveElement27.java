package codeofli.leetcode.data_structure.array_and_strings.two_pointer;

public class RemoveElement27 {
    /**
     * my:
     * two pointer
     */
    public int removeElement1(int[] nums, int val) {
        // j为不为val的指针，即下一个将要赋值的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    /**
     * leetcode 双指针优化
     * 因为题目不要求保持原来的顺序
     */
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] ==val){
                nums[left] = nums[right--];
            }else{
                left++;
            }
        }
        return left;
    }
}
