package com.lmz.algorithm_learning.leetcode;

import com.lmz.leetcode_practice.data_structure.linked_list.util.ListNode;
import com.lmz.leetcode_practice.data_structure.tree.binary_tree.util.TreeNode;

import java.util.*;

public class TransformUtil {

    public static String ArrayToJavaForm(String original) {
        return original.replaceAll("\\[", "{").
                replaceAll("\\]", "}").
                replaceAll("\"", "'");
    }

    /**
     * @param original "[4,2,1,3]"
     * @return
     */
    public static int[] toIntArray(String original) {
        String s = original.replaceAll("\\[", "").
                replaceAll("\\]", "").
                // 有可能有空格
                        replaceAll("\\s+", "").
                // 特殊的空格
                        replaceAll(" ", "");
        if ("".equals(s)) {
            return new int[0];
        }
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        return nums;
    }

    public static long[] toLongArray(String original) {
        String s = original.replaceAll("\\[", "").
                replaceAll("\\]", "").
                // 有可能有空格
                        replaceAll("\\s+", "").
                // 特殊的空格
                        replaceAll(" ", "");
        if ("".equals(s)) {
            return new long[0];
        }
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        return Arrays.stream(nums).mapToLong(a -> (long) a).toArray();
    }

    /**
     * @param original 输入格式：[[5,3],[4,0],[2,1]]
     * @return
     */
    public static int[][] toIntMatrix(String original) {
        if ("".equals(original)) {
            return new int[0][0];
        }

        String substring = original.substring(1, original.length() - 1);
        if ("".equals(substring)) {
            return new int[0][0];
        }
        //先统一为：[5,3],[4,0],[2,1],
        String[] split = (substring + ",").split("],");

        int[][] matrix = new int[split.length][];
        int index = 0;
        for (String s : split) {
            matrix[index++] = toIntArray(s.substring(1));
        }
        return matrix;
    }


    /**
     * @param matrix ： 二维数组
     * @return 输出格式：[[5,3],[4,0],[2,1]]
     */
    public static String matrixToStr(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(',');
            }
            sb.deleteCharAt(sb.length() - 1).append("],");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ArrayToJavaForm("[[\"test.A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"test.A\",\"D\",\"E\",\"E\"]]"));
    }

    /**
     * @param original 格式
     *                 [
     *                 ["1","1","1","1","0"],
     *                 ["1","1","0","1","0"],
     *                 ["1","1","0","0","0"],
     *                 ["0","0","0","0","0"]
     *                 ]
     * @return
     */
    public static char[][] toCharMatrix(String original) {
        if ("".equals(original)) {
            return new char[0][0];
        }
        //可能中间存在换行符
        original = original.replaceAll("\n", "").replaceAll("\"", "");
        //先统一为：[5,3],[4,0],[2,1],
        String[] split = (original.substring(1, original.length() - 1) + ",").split("],");

        char[][] matrix = new char[split.length][];
        int index = 0;
        for (String s : split) {
            matrix[index++] = toCharArray(s.substring(1));
        }
        return matrix;
    }

    public static char[] toCharArray(String original) {
        String s = original.replaceAll("\\[", "").
                replaceAll("\\]", "").
                replaceAll(" ", "");
        if ("".equals(s)) {
            return new char[0];
        }
        String[] split = s.split(",");
        char[] nums = new char[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = split[i].charAt(0);
        }
        return nums;
    }

    /**
     * @param original 输入格式："[\"foo\",\"bar\"]"
     * @return
     */
    public static String[] toStringArray(String original) {
        String s = original.replaceAll("\\[", "").
                replaceAll("\\]", "").
                replaceAll(" ", "")
                .replaceAll("\"", "");
        if ("".equals(s)) {
            return new String[0];
        }
        String[] split = s.split(",");
        return split;
    }

    public static ArrayList<Integer> toArrayList(String original) {
        int[] ints = toIntArray(original);
        return getArrayList(ints);
    }

    public static ArrayList<List<Integer>> toDoubleArrayList(String original) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if ("".equals(original)) {
            return res;
        }

        String substring = original.substring(1, original.length() - 1);
        if ("".equals(substring)) {
            return res;
        }
        //先统一为：[5,3],[4,0],[2,1],
        String[] split = (substring + ",").split("],");
        for (var item : split) {
            int[] ints = toIntArray(item);
            res.add(getArrayList(ints));
        }

        return res;
    }

    /**
     * int[] -> ArrayList<Integer>
     *
     * @param ints int[]
     * @return
     */
    private static ArrayList<Integer> getArrayList(int[] ints) {
        ArrayList<Integer> list = new ArrayList<>(ints.length);
        for (int item : ints) {
            list.add(item);
        }
        return list;
    }

    /**
     * String[] -> ArrayList<String>
     *
     * @param strings String[]
     * @return
     */
    private static ArrayList<String> ToArrayList(String[] strings) {
        ArrayList<String> list = new ArrayList<>(strings.length);
        for (String item : strings) {
            list.add(item);
        }
        return list;
    }

    public static ArrayList<String> toStringArrayList(String s) {
        String[] strings = toStringArray(s);
        return ToArrayList(strings);
    }

    /**
     * input format: [true,true,true,false,false]
     *
     * @param original
     * @return
     */
    public static boolean[] toBoolArray(String original) {
        String s = original.replaceAll("\\[", "").
                replaceAll("\\]", "").
                // 有可能有空格
                        replaceAll("\\s+", "").
                // 特殊的空格
                        replaceAll(" ", "");
        if ("".equals(s)) {
            return new boolean[0];
        }
        String[] split = s.split(",");
        boolean[] nums = new boolean[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Boolean.parseBoolean(split[i]);
        }
        return nums;
    }


    public static ListNode toLinkedList(String format) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int[] nums = toIntArray(format);
        for (int x : nums) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    /**
     * @param format 完全二叉树的形式"[10,5,-3,3,2,null,11,3,-2,null,1]"
     * @return leetcode 结构的链表
     */
    public static TreeNode toBinaryTree(String format) {
        String[] a = toStringArray(format);
        int n = a.length;
        TreeNode root = toTreeNode(a[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int idx = 1;
        while (!q.isEmpty() && idx < n) {
            int size = q.size();
            for (int i = 0; i < size && idx < n; i++) {
                TreeNode node = q.poll();
                node.left = toTreeNode(a[idx++]);
                if (node.left != null)
                    q.add(node.left);
                if(idx >= n) break;
                node.right = toTreeNode(a[idx++]);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return root;
    }

    private static TreeNode toTreeNode(String s) {
        if ("null".equals(s)) return null;
        return new TreeNode(Integer.parseInt(s));
    }
}
