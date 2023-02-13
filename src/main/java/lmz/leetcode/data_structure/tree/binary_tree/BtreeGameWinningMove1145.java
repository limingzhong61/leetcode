package lmz.leetcode.data_structure.tree.binary_tree;

/**
 * @author: limingzhong
 * @create: 2023-02-03 11:35
 */
public class BtreeGameWinningMove1145 {
    /**
     * 贪心+dfs
     * 以 xxx 为根，它的三个邻居（左儿子、右儿子和父节点）就对应着三棵子树：
     * 左子树，右子树，父节点子树
     * 哪棵子树最大，二号玩家就选哪棵。
     * 其中父节点子树 = 总节点数-（左+右+1）
     * 因为n1先走，所以可以走两棵子树。n2只能选择其中一棵子树。
     */
    int leftCount = 0, rightCount = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int total = dfs(root, x);
        int n2 = Math.max(leftCount,Math.max(rightCount,total - rightCount-leftCount - 1));
        return total - n2 < n2;
    }

    private int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int lc = dfs(root.left, x);
        int rc = dfs(root.right, x);
        if (root.val == x) {
            leftCount = lc;
            rightCount = rc;
        }
        return lc + rc + 1;
    }
}
