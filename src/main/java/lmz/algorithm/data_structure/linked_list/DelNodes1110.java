package lmz.algorithm.data_structure.linked_list;

import lmz.algorithm.data_structure.tree.binary_tree.normal.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-05-30 9:49
 */
public class DelNodes1110 {
    /**
     * 树中的节点数最大为 1000。
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        List<TreeNode> ans = new ArrayList<>();
        for (int x : to_delete) {
            set.add(x);
        }
        if (dfs(root, set, ans) != null) ans.add(root);
        return ans;
    }



    /**
     * 递归删除
     */
    private TreeNode dfs(TreeNode cur, HashSet<Integer> set, List<TreeNode> ans) {
        if (cur == null) {
            return null;
        }
        cur.left = dfs(cur.left,set,ans);
        cur.right = dfs(cur.right,set,ans);
        if(!set.contains(cur.val)){
            return cur;
        }
        if(cur.left != null) ans.add(cur.left);
        if(cur.right != null) ans.add(cur.right);
        return  null;
    }
}
