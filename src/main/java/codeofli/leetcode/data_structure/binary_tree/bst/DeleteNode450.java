package codeofli.leetcode.data_structure.binary_tree.bst;

import codeofli.leetcode.data_structure.binary_tree.TreeNode;

public class DeleteNode450 {
    /**
     * 叶子结点直接删除，非叶子结点删除后用中序遍历的前驱叶子结点代替。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode pre = null;
        inorder(root,key,pre);
        return  null;
    }

    private void inorder(TreeNode root, int key, TreeNode pre) {
        //if(root == key){
        //    pre.left = root.left;
        //    pre.right = root.right;
        //}
    }
}
