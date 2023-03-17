package lmz.leetcode.data_structure.tree.binary_tree.normal;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) { //两者全为空
            return true;
        } else if (leftNode == null || rightNode == null) { // 只有一个为空
            return false;
        } else if (leftNode.val == rightNode.val) {
            boolean left = symmetric(leftNode.left, rightNode.right);
            boolean right = symmetric(leftNode.right, rightNode.left);
            return left && right;
        } else {
            return false;
        }
    }

    /**
     * 迭代方法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        //if(root == null){
        //    return true;
        //}
        Queue<TreeNode> leftQueue = new LinkedList();
        Queue<TreeNode> rightQueue = new LinkedList();
        leftQueue.offer(root);
        rightQueue.offer(root);
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (leftNode == null && rightNode == null) { //两者全为空
                continue;
            } else if (leftNode == null || rightNode == null) { // 只有一个为空
                return false;
            } else if (leftNode.val == rightNode.val) {
                leftQueue.offer(leftNode.left);
                rightQueue.offer(rightNode.right);
                leftQueue.offer(leftNode.right);
                rightQueue.offer(rightNode.left);
            } else {
                return false;
            }
        }
        return true;
    }
}
