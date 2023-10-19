package com.lmz.leetcode.practice.data_structure.tree.binary_tree.traversal;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;
import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-06-11 17:56
 */
public class PathSum437 {
    /**
     * 递归,list记录，前缀和+hashMap
     * 记录[0,j]内前缀和的次数，如果存在sum[j] - target则加上map中记录的个数即可。
     * 注：提前需要记录0，表示最开始的状态
     * 用list记录当前节点到根节点的节点值
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        cnt = 0;
        HashMap<Long, Integer> counter = new HashMap<>();
        counter.put(0L,1);   // 提前需要记录0，表示最开始的状态
        dfs(root, targetSum, counter, 0L);
        return cnt;
    }

    int cnt = 0;

    private void dfs(TreeNode root, int targetSum, HashMap<Long, Integer> counter, long sum) {
        if (root == null) return;

        sum += root.val;
        cnt += counter.getOrDefault(sum - targetSum,0);

        counter.put(sum, counter.getOrDefault(sum, 0) + 1);
        dfs(root.left, targetSum, counter, sum);
        dfs(root.right, targetSum, counter, sum);
        counter.put(sum, counter.get(sum) - 1); //恢复现场
    }

    // long 防止越界
    private boolean checkSum(ArrayList<Integer> list, long targetSum) {

        for (int i = list.size() - 1; i >= 0; i--) {
            targetSum -= list.get(i);
            if (targetSum == 0) {
                cnt++;
                //System.out.println(list.toString());
            }
        }
        return false;
    }

    class Solution {
        /**
         * 递归
         * 用list记录当前节点到根节点的节点值
         *
         * @param root
         * @param targetSum
         * @return
         */
        public int pathSum(TreeNode root, int targetSum) {
            cnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            dfs(root, targetSum, list);
            return cnt;
        }

        int cnt = 0;

        private void dfs(TreeNode root, int targetSum, ArrayList<Integer> list) {
            if (root == null) return;
            list.add(root.val);
            if (checkSum(list, targetSum)) {
                cnt++;
            }
            dfs(root.left, targetSum, list);
            dfs(root.right, targetSum, list);
            list.remove(list.size() - 1); //恢复现场
        }

        // long 防止越界
        private boolean checkSum(ArrayList<Integer> list, long targetSum) {

            for (int i = list.size() - 1; i >= 0; i--) {
                targetSum -= list.get(i);
                if (targetSum == 0) {
                    cnt++;
                    //System.out.println(list.toString());
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        PathSum437 pathSum437 = new PathSum437();
        //System.out.println(pathSum437.pathSum(TransformUtil.toBinaryTree("[1,null,2,null,3,null,4,null,5]"), 3));
        test(pathSum437, "[10,5,-3,3,2,null,11,3,-2,null,1]", 8, 3);
        test(pathSum437, "[5,4,8,11,null,13,4,7,2,null,null,5,1]", 22, 3);
        //test(pathSum437, "[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]", 0, 3);
    }

    private static void test(PathSum437 pathSum437, String format, int targetSum, int result) {
        System.out.println(pathSum437.pathSum(TransformUtil.toBinaryTree(format), targetSum));
        System.out.println(pathSum437.pathSum(TransformUtil.toBinaryTree(format), targetSum) == result);
    }

}
