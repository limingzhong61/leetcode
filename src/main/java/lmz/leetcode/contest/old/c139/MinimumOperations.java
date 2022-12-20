package lmz.leetcode.contest.old.c139;

import lmz.leetcode.data_structure.tree.binary_tree.TreeNode;
import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class MinimumOperations {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            var list = new int[size];
            int idx = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                list[idx++] = poll.val;
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
            }
            cnt += getCnt(list);
            System.out.printf("%d\n", getCnt(list));
        }
        return cnt;
    }

    private int getCnt(int[] list) {
        int n = list.length;
        int[] copy = Arrays.copyOf(list, n);
        Arrays.sort(copy);
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(copy[i], i);
        }
        int left = 0;
        int cnt = 0;
        while (left < n) {
            while (left < n && copy[left] == list[left]) {
                left++;
            }
            if (left == n) {
                break;
            }
            int temp = list[left];
            int chageIdx = idxMap.get(list[left]);
            list[left] = list[chageIdx];
            list[chageIdx] = temp;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        MinimumOperations minimumOperations = new MinimumOperations();
        System.out.println( minimumOperations.getCnt(TransformUtil.toIntArray("[4,3]")));
    }
}
