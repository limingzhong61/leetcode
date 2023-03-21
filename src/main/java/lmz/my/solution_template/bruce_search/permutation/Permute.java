package lmz.my.solution_template.bruce_search.permutation;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 全排列模板，没有重复元素
 */
public class Permute {

    public List<List<Integer>> permuteUnique(int[] nums) {
        permutation(nums, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 下一次排列：获取全排列
     */
    private void permutation(int[] nums, int cur) {
        if (cur == nums.length) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int item : nums) {
                temp.add(item);
            }
            res.add(temp);
            return;
        }
        //在[cur,n]中选择一个数nums[i]为第cur的数
        for (int i = cur; i < nums.length; i++) {
            swap(nums, i, cur);
            permutation(nums, cur + 1);
            swap(nums, i, cur); //交换回来，方便下一次递归
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        //System.out.println(permute.permuteUnique(TransformUtil.toIntArray("[1,1,2]")));
        System.out.println(permute.permuteUnique(IntStream.range(0, 9).toArray()).size());
    }


}
