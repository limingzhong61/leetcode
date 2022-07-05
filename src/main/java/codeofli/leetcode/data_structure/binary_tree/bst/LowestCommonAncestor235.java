package codeofli.leetcode.data_structure.binary_tree.bst;

//import codeofli.leetcode.data_structure.binary_tree.TreeNode;

import codeofli.leetcode.data_structure.binary_tree.TreeNode;

public class LowestCommonAncestor235 {
    /**
     * my:利用二叉树的性质
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val ){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                return root = root.right;
            }else { // p、q 分别在root两侧
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor235 lowestCommonAncestor235 = new LowestCommonAncestor235();
        //lowestCommonAncestor235.lowestCommonAncestor()
    }
}
