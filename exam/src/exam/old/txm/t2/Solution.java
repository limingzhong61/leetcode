package exam.old.txm.t2;


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


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param trees TreeNode类一维数组
     * @return int整型
     */
    public int cntOfMethods(TreeNode[] trees) {
        // 最大深度的叶子结点个数
        int n = trees.length;
        final long mod = 1_000_000_000 + 7;
        long ans = 0;
        long[] f = new long[n];
        for (int i = 0; i < n; i++) {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(trees[i]);
            while (!q.isEmpty()) {
                int size = q.size();

                for (int k = 0; k < size; k++) {
                    TreeNode node = q.poll();
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                f[i] =  size * 2L;
            }
        }
        // System.out.println(Arrays.toString(f));
        long g = 1;
        // n!
        for (int i = 2; i < n; i++) {
            g = ((g * i) % mod);
        }

        for (int i = 0; i < n; i++) {
            long f1 = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    f1 = (f1 * f[j]) % mod;
                }
            }
            f1 = (f1 * g) % mod;
            // System.out.println(f1);
            ans = (ans + f1) % mod;
        }
        return (int) ans;
    }
}












