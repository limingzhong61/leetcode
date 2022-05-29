package codeofli.leetcode.binary_tree;


import java.util.LinkedList;
import java.util.Queue;

public class hasPathSum {


    /**
     * 递归版本
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        int sum = 0;
        return check(root, sum, targetSum);
    }

    private boolean check(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        //System.out.println(sum);
        if (root.right == null && root.left == null) {
            return sum == targetSum;
        }
        return check(root.left, sum, targetSum) || check(root.right, sum, targetSum);
    }


    /**
     * 迭代版本,利用bfs
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> sumQueue = new LinkedList();
        if (root == null) {
            return false;
        }
        queue.offer(root);
        sumQueue.offer(root.val);
        while (!queue.isEmpty()) {
            root = queue.poll();
            int sum = sumQueue.poll();
            if (root.right == null && root.left == null && sum == targetSum) {
                return true;
            }
            if (root.left != null) {
                queue.offer(root.left);
                sumQueue.offer(root.left.val + sum);
            }
            if (root.right != null) {
                queue.offer(root.right);
                sumQueue.offer(root.right.val + sum);
            }
        }
        return false;
    }


}
