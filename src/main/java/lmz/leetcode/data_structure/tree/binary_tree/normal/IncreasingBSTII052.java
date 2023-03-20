package lmz.leetcode.data_structure.tree.binary_tree.normal;

public class IncreasingBSTII052 {
    TreeNode p;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyHead = new TreeNode();
        p = dummyHead;
        p.right = null;
        inOrder(root);
        return  dummyHead.right;
    }

    private void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        p.left = null;
        p.right = root;
        p = p.right;
        inOrder(root.right);
    }
}
