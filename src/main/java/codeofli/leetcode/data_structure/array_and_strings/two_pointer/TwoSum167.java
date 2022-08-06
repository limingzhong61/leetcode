package codeofli.leetcode.data_structure.array_and_strings.two_pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum167 {
    /**
     * my:
     * two pointer
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1,right+1};
            } else if (sum > target) { //超过了，
                right--;
            }else { //小于
                left++;
            }
        }
        return new int[] {-1,-1};
    }

    /**
     * my:
     * hashMap
     */
    public int[] twoSum1(int[] numbers, int target) {
        int length = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(numbers[i], i + 1);
        }
        int[] ans = new int[2];
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ans[0] = i + 1;
                ans[1] = map.get(target - numbers[i]);

                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSum167 twoSum167 = new TwoSum167();
        System.out.println(Arrays.toString(twoSum167.twoSum(new int[]{0, 0, 3, 4}, 0)));
    }
}
