package lmz.leetcode.data_structure.tree.binary_tree.bst;


import lmz.leetcode.data_structure.tree.binary_tree.TreeNode;

public class SearchBST700 {
    /**
     * 迭代
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null){
            if(cur.val == val){
                return cur;
            }else if(cur.val < val){
                cur= cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }
}
