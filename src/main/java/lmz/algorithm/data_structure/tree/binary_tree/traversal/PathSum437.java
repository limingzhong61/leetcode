package lmz.algorithm.data_structure.tree.binary_tree.traversal;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;
import lmz.my.leetcode.TransformUtil;

/**
 * @author: limingzhong
 * @create: 2023-06-11 17:56
 */
public class PathSum437 {

    public int pathSum(TreeNode root, int targetSum) {
        return f(root, targetSum, 0);
    }

    private int f(TreeNode root, int targetSum, int sum) {
        if (root == null) return 0;
        sum += root.val;
        if(sum == targetSum){
            System.out.println(root.val);
        }
        return (sum == targetSum ? 1 : 0) + f(root.left, targetSum, 0) + f(root.right, targetSum, 0) +
                f(root.left,targetSum, sum) + f(root.right, targetSum, sum);
    }

    public static void main(String[] args) {
        PathSum437 pathSum437 = new PathSum437();
        System.out.println(pathSum437.pathSum(TransformUtil.toBinaryTree("[1,null,2,null,3,null,4,null,5]"), 3));
    }

}
