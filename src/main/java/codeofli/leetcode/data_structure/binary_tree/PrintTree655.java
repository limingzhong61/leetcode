package codeofli.leetcode.data_structure.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintTree655 {
    int height;

    public List<List<String>> printTree(TreeNode root) {
        height = treeHeight(root);

        int row = height, col = (1 << height) - 1;
        List<List<String>> res = new ArrayList<>(row);

        List<String> layer = new ArrayList<>(col);
        for (int i = 0; i < row; i++) {
            layer.clear();
            for (int j = 0; j < col; j++) {
                layer.add("");
            }
            res.add(new ArrayList(layer));
        }
        int mid = col / 2;
        dfs(res, root, 0, mid);
        return res;
    }

    private void dfs(List<List<String>> res, TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        res.get(row).set(col, String.valueOf(root.val));
        dfs(res, root.left, row + 1, col - (1 << (height - row -1)));
        dfs(res, root.right, row + 1, col + (1 << (height - row -1)));
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
