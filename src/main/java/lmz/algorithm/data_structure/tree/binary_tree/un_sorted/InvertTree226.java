package lmz.algorithm.data_structure.tree.binary_tree.un_sorted;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

public class InvertTree226 {
    /**
     * 递归
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tempLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempLeft);
        return root;
    }
}
