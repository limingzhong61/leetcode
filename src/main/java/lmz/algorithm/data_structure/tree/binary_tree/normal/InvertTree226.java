package lmz.algorithm.data_structure.tree.binary_tree.normal;

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
