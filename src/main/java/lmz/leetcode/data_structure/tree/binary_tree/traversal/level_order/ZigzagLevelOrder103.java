package lmz.leetcode.data_structure.tree.binary_tree.traversal.level_order;

import lmz.leetcode.data_structure.tree.binary_tree.normal.TreeNode;
import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.EncodeTree;

import java.util.*;

public class ZigzagLevelOrder103 {
    /**
     * leetcode:
     * 在层次遍历的基础上添加一个双端队列遍历deque用于存储z字遍历结果：即
     *
     * 在广度优先搜索遍历当前层节点拓展下一层节点的时候我们仍然从左往右按顺序拓展，
     * 但是对当前层节点的存储我们维护一个变量isOrderLeft 记录是从左至右还是从右至左的：
     * 如果从左至右，我们每次将被遍历到的元素插入至双端队列deque的末尾。 因为当前从左到右，下一层就是从右到左了
     * 如果从右至左，我们每次将被遍历到的元素插入至双端队列deque的头部。
     * 每次获得的deque形成的list就是答案
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean leftOrder = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            Deque<Integer> levelList = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) { //从左到右遍历
                TreeNode node = deque.pollFirst();
                if(leftOrder){ //如果从左至右，我们每次将被遍历到的元素插入至双端队列deque的末尾。因为当前从左到右，下一层就是从右到左了
                    levelList.addLast(node.val);
                }else{
                    levelList.addFirst(node.val);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(new LinkedList<Integer>(levelList));
            leftOrder = !leftOrder;
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst(); //从左到右遍历
                temp.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(temp);
            size = deque.size();
            if (size == 0) {
                break;
            }
            temp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast(); //从右到左遍历
                temp.add(node.val);
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder103 zigzagLevelOrder103 = new ZigzagLevelOrder103();
        System.out.println(zigzagLevelOrder103.zigzagLevelOrder(EncodeTree.deserialize("[3,9,20,null,null,15,7]")));
        System.out.println(zigzagLevelOrder103.zigzagLevelOrder(EncodeTree.deserialize("[1,2,3,4,5,6,7,8,9,10,11,12,13]")));
    }
}
