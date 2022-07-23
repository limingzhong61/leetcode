package codeofli.leetcode.graph_parse_ds.two_pointer;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.Arrays;

public class Exchange21 {
    /**
     *对位交换
     */
    public int[] exchange(int[] nums) {
        int odd = 0, even = nums.length - 1;
        while (odd < even) {
            while (odd < even && nums[odd] % 2 == 1) odd++;
            while (odd < even && nums[even] % 2 == 0) even--;
            int temp = nums[odd];
            nums[odd] = nums[even];
            nums[even] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Exchange21 exchange21 = new Exchange21();
        System.out.println(Arrays.toString(exchange21.exchange(StringTransformUtil.toIntArray("[1,2,3,4]"))));
        System.out.println(Arrays.toString(exchange21.exchange(StringTransformUtil.toIntArray("[1,3,2,4]"))));
    }
}
