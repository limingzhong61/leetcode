package exam.old.ali.dwy.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int numOfNode(TreeNode root) {
        if (root == null) return 0;
        // write code here
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int mustSize = 1;
        boolean remove = false;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (mustSize != size) {
                remove = true;
            }

            // System.out.println(mustSize);
            mustSize *= 2;
            for (int i = 0; i < size; i++) {
                if(remove){
                    ans++;
                }
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }
}
