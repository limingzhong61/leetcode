package codeofli.leetcode.data_structure.binary_tree.bst;

import codeofli.leetcode.data_structure.binary_tree.TreeNode;
import codeofli.my.leetcode.EncodeTree2;

import java.util.HashMap;

public class DeleteNode {
    /**
     * 中序遍历，删除
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        inOrder(cur,key);
        return root;
    }
    TreeNode pre = null;
    HashMap<TreeNode,TreeNode> parentNode = new HashMap<>();
    private void inOrder(TreeNode root, int key) {
        if(root == null){
            return;
        }
        deleteNode(root.left,key);

        parentNode.put(root,pre);
        if(root.val == key){
            if(root.left == null && root.right == null){ //叶子结点删除
                TreeNode parent = parentNode.get(root);
                if(parent != null){
                    if(parent.left == root){
                        parent.left = null;
                    }else{
                        parent.right = null;
                    }
                }
                return;
            }else{ //非叶节点删除
                pre.left = root.left != pre ? root.left : null;
                pre.right = root.right != pre ? root.right : null;
                TreeNode rootParent = parentNode.get(root);
                if(rootParent != null){
                    if(rootParent.left == root){
                        rootParent.left = pre;
                    }else{
                        rootParent.right = pre;
                    }
                }
                TreeNode preParent = parentNode.get(pre);
                if(preParent != null){
                    if(preParent.left == pre){
                        preParent.left = null;
                    }else{
                        preParent.right = null;
                    }
                }
            }
        }
        pre = root;
        deleteNode(root.right,key);
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        System.out.println(EncodeTree2.serialize(deleteNode.deleteNode(EncodeTree2.deserialize("[5,3,6,2,4,null,7]"), 3)));
    }
}
