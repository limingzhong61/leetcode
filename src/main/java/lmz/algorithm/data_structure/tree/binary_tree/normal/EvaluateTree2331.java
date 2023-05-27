package lmz.algorithm.data_structure.tree.binary_tree.normal;

/**
 * @author: limingzhong
 * @create: 2023-02-06 18:25
 */
public class EvaluateTree2331 {
    //树中节点数目在 [1, 1000] 之间。
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val != 0;
        }
        if(root.val == 2){ // or
            return evaluateTree(root.left) || evaluateTree(root.right);
        }else{ // and
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
