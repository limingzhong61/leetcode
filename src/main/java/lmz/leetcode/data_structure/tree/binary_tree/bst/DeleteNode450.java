package lmz.leetcode.data_structure.tree.binary_tree.bst;

import lmz.leetcode.data_structure.tree.binary_tree.normal.TreeNode;
import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.EncodeTree2;

public class DeleteNode450 {
    /**
     * leetcode:迭代
     * 如果 <key则root.right中删除。。。
     * 先找打值为key的结点，然后分类讨论删除
     * 有左右子树，先找到后继节点，并删除后继节点，然后用找到的后继节点替换节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.val == key) {
            if (cur.left == null && cur.right == null) {
                cur = null;
            } else if (cur.left == null) {
                cur = cur.right;
            } else if (cur.right == null) {
                cur = cur.left;
            } else { //有左右子树，先找到后继节点，并删除后继节点，然后用找到的后继节点替换节点
                //删除后继节点successor,用后继节点successor替换cur
                TreeNode successor = cur.right, successorParent = cur; //中序遍历的后继节点，为右子树的最左结点
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                if (successorParent == cur) { //cur.right == successor
                    successorParent.right = successor.right; //将后继节点的右子树归结到cur上，偏于统一处理
                } else {
                    successorParent.left = successor.right; // 将后面一部分删除successor后规整。
                }
                successor.left = cur.left;
                successor.right = cur.right;
                cur = successor;
            }
        }
        if (curParent == null) {
            return cur;
        } else { //将删除后的cur，放回原来的位置
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }

    /**
     * leetcode:递归删除
     * 如果 <key则root.right中删除。。。
     * 先找打值为key的结点，然后分类讨论删除
     * 有左右子树，先找到后继节点，并删除后继节点，然后用找到的后继节点替换节点
     */
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else { // root.val == key
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else { //有左右子树，先找到后继节点，并删除后继节点，然后用找到的后继节点替换节点
                TreeNode successor = root.right; //中序遍历的后继节点，为右子树的最左结点
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.right = deleteNode(root.right, successor.val); //先在右子树中，删除后继节点
                successor.left = root.left;
                successor.right = root.right;
                return successor;
            }
        }
    }


    public static void main(String[] args) {
        DeleteNode450 deleteNode = new DeleteNode450();
        System.out.println(EncodeTree2.serialize(deleteNode.deleteNode(EncodeTree2.deserialize("[5,3,6,2,4,null,7]"), 3)));
    }
}
