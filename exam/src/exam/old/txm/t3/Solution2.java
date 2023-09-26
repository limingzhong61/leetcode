//package exam.old.txm.t3;
//
//
//import javax.swing.tree.TreeNode;
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Queue;
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param trees TreeNode类一维数组
//     * @return int整型
//     */
//    public int cntOfMethods(TreeNode[] trees) {
//        // 最大深度的叶子结点个数
//        int n = trees.length;
//        final long mod = 1_000_000_000 + 7;
//        long ans = 0;
//        for (int i = 0; i < n; i++) {
//            Queue<TreeNode> q = new ArrayDeque<>();
//            q.add(trees[i]);
//            long cnt = 0;
//            while (!q.isEmpty()) {
//                int size = q.size();
//                cnt = size;
//                for (int k = 0; k < size; k++) {
//                    TreeNode node = q.poll();
//                    if (node.left != null) {
//                        q.add(node.left);
//                    }
//                    if (node.right != null) {
//                        q.add(node.right);
//                    }
//                }
//            }
//            ans = (ans + (cnt * 2) % mod) % mod;
//        }
//        // n!
//        for(int i = 1; i < n; i++){
//            ans = (ans * i) % mod;
//        }
//        return (int) ans;
//    }
//}