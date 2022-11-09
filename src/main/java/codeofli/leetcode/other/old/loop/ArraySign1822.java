package codeofli.leetcode.other.old.loop;

public class ArraySign1822 {
    public int arraySign(int[] nums) {
        boolean positive = true;
        for(int item : nums){
            if(item == 0){
                return 0;
            }else if(item < 0){
                positive = !positive;
            }
        }
        return positive ? 1 : -1;
    }
}
