package lmz.algorithm.data_structure.tree.binary_tree.normal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddOneRow623 {
    /**
     * DFS
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) { //创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
            return new TreeNode(val, root, null);
        }
        if(depth == 2){
            root.left = new TreeNode(val,root.left,null);
            root.right = new TreeNode(val,null,root.right);
        }else{
            root.left = addOneRow1(root.left,val,depth-1);
            root.right = addOneRow1(root.right,val,depth-1);
        }
       return  root;
    }
    /**
     * BFS
     */
    public TreeNode addOneRow2(TreeNode root, int val, int depth) {
        if (depth == 1) { //创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
            return new TreeNode(val, root, null);
        }
        List<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        for(int i = 0; i < depth -1; i++){
            List<TreeNode> temp = new LinkedList<>();
            for(TreeNode node : curLevel){
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }
            curLevel = temp;
        }
        for (TreeNode node : curLevel) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }
    /**
     * 层次遍历
     * 节点数在[1, 104]范围内
     * 树的深度在[1, 104]范围内
     * -100 <= Node.val <= 100
     * -105<= val <= 105
     * 1 <= depth <= the depth of tree + 1
     */
    public TreeNode addOneRow1(TreeNode root, int val, int depth) {
        if (depth == 1) { //创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curDepth == depth - 1 || curDepth == depth) { //the depth of tree + 1
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    node.left = new TreeNode(val,node.left,null);
                    node.right = new TreeNode(val,null,node.right);
                }
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
            }
            curDepth++;
        }
        return root;
    }
}
