package lmz.algorithm.other.easy.old;

import lmz.algorithm.data_structure.tree.binary_tree.normal.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: codeofli
 * @create: 2022-10-31 23:09
 */
public class FindMode501 {
    /**
     * 中序遍历
     */
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for(var entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max =Math.max(map.get(root.val),max);
        dfs(root.left);
        dfs(root.right);
    }
}
