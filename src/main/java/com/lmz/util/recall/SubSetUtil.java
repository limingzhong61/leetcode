package com.lmz.util.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-15 22:35
 */
public class SubSetUtil {
    /**
     * 思路：选和不选
     * 在nums集合中生成全部的子集
     *
     * @param nums 集合
     * @return nums集合中生成全部的子集
     */
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    private static void dfs(int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[i]
        dfs(nums, i + 1);
        // 选 nums[i]
        path.add(nums[i]);
        dfs(nums, i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }

    /**
     * 二进制法：用二进制来表示{0, 1, 2,…,n-1}的子集S：从右往左第i位（各位从0开始编
     * 号）表示元素i是否在集合S中。
     */
    public static List<List<Integer>> subsets5(int[] nums) {
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


    //方法二：答案的视角（选哪个数）
    public List<List<Integer>> subsets2(int[] nums) {
        dfs2(nums,0);
        return ans;
    }
    //private final List<List<Integer>> ans = new ArrayList<>();
    //private final List<Integer> path = new ArrayList<>();

    private void dfs2(int[] nums, int i) {
        ans.add(new ArrayList<>(path)); // 固定答案
        if (i == nums.length) return;
        for(int j = i; j < nums.length; j++){    // 枚举选择的数字
            path.add(nums[j]);
            dfs(nums,j+1);
            path.remove(path.size()-1);     // 恢复现场
        }
    }

    public  static int[]  sortedSubSet(int n){
        return SortedSubSet.printNumbers(n);
    }

    static class SortedSubSet{
        /**
         子集生成： 模拟大数
         */
        static List<String>  ans  = new ArrayList<>();
        public static int[]  printNumbers(int n) {
            dfs(n,0);
            int[] res = new int[ans.size()];
            for(int i = 0; i < ans.size(); i++){
                if(ans.get(i).equals("")) continue;
                res[i] = Integer.parseInt(ans.get(i));
            }
            return res;
        }
        static StringBuilder sb = new StringBuilder();
        // 生成长度为 len 的数字，正在确定第cur位（从左往右）
        static void  dfs(int n,int cur){
            if(cur == n){
                ans.add(sb.toString());
                //System.out.println(ans.get(ans.size()-1));
                return;
            }
            //int start = cur == 0 ? 1 : 0; //第0位只能从1开始
            for(int i = 0; i < 10; i++){
                sb.append(i);
                dfs(n,cur+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        //System.out.println(subsets(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        //System.out.println(subsets5(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(Arrays.toString(sortedSubSet(3)));
    }
}
