package lmz.algorithm.other.old.search_and_recur;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

public class IsBalanced55II {
    /**
     * my:递归
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     */
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        recur(root);
        return res;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = recur(root.left);
        int rightDeep = recur(root.right);
        int maxDeep,minDeep;
        if(leftDeep > rightDeep){
            maxDeep = leftDeep;
            minDeep = rightDeep;
        }else {
            maxDeep = rightDeep;
            minDeep = leftDeep;
        }
        if(maxDeep - minDeep > 1){
            res = false;
            return -1;
        }
        return maxDeep + 1;
    }


}
