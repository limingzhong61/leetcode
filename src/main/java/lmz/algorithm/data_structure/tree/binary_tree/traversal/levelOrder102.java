package lmz.algorithm.data_structure.tree.binary_tree.traversal;


import lmz.algorithm.data_structure.tree.binary_tree.un_sorted.TreeNode;

import java.util.*;

public class levelOrder102 {
    /**
     * 层次遍历
     * 利用队列长度
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for(int i = 0; i < currentLevelSize; i++){
                root = queue.poll();
                level.add(root.val);
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            res.add(level);
        }
        return res;
    }








    /**
     * 我的结题思路，用lastRight标记一层的最右结点（即结束结点）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null){
            return res;
        }
        deque.add(root);
        //标记一层的最右结点（即结束结点）
        TreeNode  lastRight = root;
        List<Integer> addList = new ArrayList<>();
        while (!deque.isEmpty()) {
            root = deque.poll();
            if(root.left != null){
                deque.add(root.left);
            }
            if(root.right != null){
                deque.add(root.right);
            }
            addList.add(root.val);
            if(root == lastRight){ //遍历完一层
                res.add(addList);
                addList = new ArrayList<>();
                if(!deque.isEmpty()){
                    lastRight = deque.getLast(); //
                }
            }
        }
        return res;
    }

}
