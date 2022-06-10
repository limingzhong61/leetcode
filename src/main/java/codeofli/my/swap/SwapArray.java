package codeofli.my.swap;

public class SwapArray {

    public static void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
