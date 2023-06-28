package lmz.algorithm.other.search_and_recur;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder33III {

    /**
     * 法二：
     * 双端队列
     * 每次开始遍历取k = queue.size()，遍历的k个元素都是同一层
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            //正序
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = deque.removeFirst();
                list.add(cur.val);
                if(cur.left != null){
                    deque.addLast(cur.left);
                }
                if(cur.right != null){
                    deque.addLast(cur.right);
                }
            }
            res.add(list);
            list = new ArrayList<>();
            //逆序
            size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = deque.removeLast();
                list.add(cur.val);
                if(cur.right != null){
                    deque.addLast(cur.right);
                }
                if(cur.left != null){
                    deque.addLast(cur.left);
                }
            }
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    }
}
