package codeofli.leetcode.everyday.find.binary_search;

public class Rotate189 {
    public void rotate(int[] nums, int k) {

        k %= nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    public static void reverse(int start, int end, int[] a) {
        for (; start < end; start++, end--) {
            int temp = a[start];    //引入中间变量
            a[start] = a[end];
            a[end] = temp;
        }
    }

}
