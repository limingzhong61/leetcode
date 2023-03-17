package lmz.leetcode.data_structure.tree.binary_tree.normal;

public class IsSubtree572 {
    /**
     * leetcode:深度优先搜索序列上做串匹配
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return   checkTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    /**
     * 递归：深度优先搜索暴力匹配
     */
    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return   checkTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean checkTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return  true;
        }else if(root == null || subRoot == null){ //只有一个为null
            return  false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return checkTree(root.left,subRoot.left) && checkTree(root.right,subRoot.right);
    }
}
