package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees652 {
    /**
     * 方法二：使用三元组进行唯一表示
     */
    Map<String, Pair<TreeNode, Integer>> seen = new HashMap<String, Pair<TreeNode, Integer>>();
    Set<TreeNode> repeat = new HashSet<TreeNode>();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] tri = {node.val, dfs(node.left), dfs(node.right)};
        String hash = Arrays.toString(tri);
        if (seen.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = seen.get(hash);
            repeat.add(pair.val1);
            return pair.val2;
        } else {
            seen.put(hash, new Pair<TreeNode, Integer>(node, ++idx));
            return idx;
        }
    }
    class Pair<V1,V2>{
        V1 val1;
        V2 val2;
        Pair(V1 val1,V2 val2){
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    /**
     * 方法一：使用序列化进行唯一表示
     * 利用递归序列化一棵树：x(左子树的序列化结果)(右子树的序列化结果)
     */
    Set<TreeNode> set = new HashSet<>();
    HashMap<String, TreeNode> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        dfs1(root);
        return new ArrayList<>(set);
    }

    private String dfs1(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append('(');
        sb.append(dfs(root.left));
        sb.append(')');
        sb.append('(');
        sb.append(dfs(root.right));
        sb.append(')');
        String serial = sb.toString();
        if (map.containsKey(serial)) {
            set.add(map.get(serial));
        } else {
            map.put(serial, root);
        }
        return serial;
    }
}
