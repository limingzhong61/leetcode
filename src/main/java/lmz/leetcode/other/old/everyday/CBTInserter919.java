package lmz.leetcode.other.old.everyday;

import lmz.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter919 {
    /**
     * leetcode: 完全二叉树的插入结点都是，子节点不满足两个结点的父节点
     * 维护一个队列依次保存和维护上诉结点。
     */
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> candidate;
        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> queue = new LinkedList<>();
            candidate = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if(!(cur.right != null && cur.left != null)){
                    candidate.add(cur);
                }
            }
        }

        public int insert(int val) {
            TreeNode cur = candidate.peek();
            TreeNode newNode = new TreeNode(val);
            candidate.add(newNode); //新加入结点两个子节点都没有
            if(cur.left == null){
                cur.left = newNode;
            }else{
                cur.right = newNode;
                candidate.poll();
            }
            return cur.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    /**
     * 树中节点数量范围为 [1, 1000]
     */
    class CBTInserter1 {
        TreeNode root;

        public CBTInserter1(TreeNode root) {
            this.root = root;
        }

        /**
         * 层次遍历
         */
        public int insert(int val) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                } else {
                    cur.left = new TreeNode(val);
                    return cur.val;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                } else {
                    cur.right = new TreeNode(val);
                    return cur.val;
                }
            }
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
