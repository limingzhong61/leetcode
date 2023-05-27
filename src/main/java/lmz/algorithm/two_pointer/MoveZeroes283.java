package lmz.algorithm.two_pointer;

public class MoveZeroes283 {

    /**
     * my:
     * 双指针
     * i：遍历
     * notZero:非零元素的下一个位置
     */
    public void moveZeroes(int[] nums) {
        int notZero = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[notZero] = nums[i];
                //nums[i] = 0;
                notZero++;
            }
        }
        //余下空位都是0
        for(; notZero < length; notZero++){
            nums[notZero] = 0;
        }
    }
}
