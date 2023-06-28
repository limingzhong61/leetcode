package lmz.util.recall;


import lmz.util.solution_template.bruce_search.permutation.Permute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 全排列模板，没有重复元素
 */
public class PermuteUtil {
    /**
     * 下一次排列：
     * 每次选择一个数i作为全排列的第cur个数，然后继续递归生成[cur+1,n]后面的数
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutation(nums, 0,res);
        return res;
    }
    private void permutation(int[] nums, int cur, List<List<Integer>> res) {
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
            permutation(nums, cur + 1, res);
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
        System.out.println(permute.permuteUnique(IntStream.range(0, 9).toArray()));
    }


}

