package lmz.leetcode.bruce_solution.bruce_search.subsets;

import lmz.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    /**
     * 二进制法：用二进制来表示{0, 1, 2,…,n-1}的子集S：从右往左第i位（各位从0开始编
     * 号）表示元素i是否在集合S中。
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) { //枚举各子集所对应的编码0, 1, 2,..., 2^n-1
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) { //判断第j位的二进制是否为1
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);      //添加被选取的元素
                }
            }
            res.add(temp);
        }
        return res;
    }

    /**
     * 位向量法：构造一个位向量B[i]，而不是直接构造子集A本身，
     * 其中当B[i]==1时表示A[i]的的元素被选取
     */
    public List<List<Integer>> subsets2(int[] nums) {
        boolean[] b = new boolean[nums.length];
        subset(nums, b, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    private void subset(int[] nums, boolean[] b, int cur) {
        int n = nums.length;
        if (cur == n) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (b[i]) {      //添加当前选取元素到集合
                    temp.add(nums[i]);
                }
            }
            res.add(temp);
            return;
        }
        b[cur] = true;     //选第cur个元素
        subset(nums, b, cur + 1);
        b[cur] = false;     //不选第cur个元素
        subset(nums, b, cur + 1);
    }

    /**
     * 增量构造法：递归
     */
    public List<List<Integer>> subsets1(int[] nums) {
        int[] record = new int[nums.length];
        subset1(nums, record, 0);
        return res;
    }


    /**
     * 用record记录选取的下标序号集合
     */
    private void subset1(int[] nums, int[] record, int cur) {
        ArrayList<Integer> temp = new ArrayList<>(cur);
        for (int i = 0; i < cur; i++) {
            temp.add(nums[record[i]]);      //添加当前选取元素到集合
        }
        res.add(temp);
        int start = cur != 0 ? record[cur - 1] + 1 : 0; //确定当前元素下标的最小可能值
        for (int i = start; i < nums.length; i++) {
            record[cur] = i;
            subset1(nums, record, cur + 1);  //递归构造子集
        }
    }

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        System.out.println(subsets78.subsets(TransformUtil.toIntArray("[1,2,3]")));
    }
}
