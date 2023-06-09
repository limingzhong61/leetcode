package lmz.my.leetcode;

import lmz.algorithm.data_structure.tree.binary_tree.un_sorted.TreeNode;
import lmz.algorithm.graph_parse_ds.search_and_recur.Codec37;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 以leetcode格式转换
 */
public class EncodeTree2 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        //int endIndex = sb.length() - 1;
        //去除尾部多余的"null,"
        while (sb.toString().endsWith("null,")) {
            sb.delete(sb.length() - 5, sb.length());
        }
        if (sb.toString().endsWith(",")) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        //"[]"
        if (data.equals("")) {
            return null;
        }
        String[] split = data.split(",");
        TreeNode[] nodes = new TreeNode[split.length];
        for (int i = 0; i < nodes.length; i++) {
            if ("null".equals(split[i])) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(split[i]));
                nodes[i].left = nodes[i].right = null;
            }
        }
        //利用双指针添加
        for (int i = 0, fast = 1; fast < nodes.length; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[fast++];
                if (fast < nodes.length)
                    nodes[i].right = nodes[fast++];
            }
        }
        return nodes[0];
    }
    public static void main(String[] args) {
        Codec37.Codec codec = new Codec37.Codec();

        System.out.println(codec.serialize(codec.deserialize("[1,2,3,null,null,4,5]")));
        System.out.println(codec.serialize(codec.deserialize("[1,2,3,null,null,4,5]"))
                .equals("[1,2,3,null,null,4,5]"));

        System.out.println(codec.serialize(codec.deserialize("[]")));
        System.out.println(codec.serialize(codec.deserialize("[]"))
                .equals("[]"));

        System.out.println(codec.serialize(codec.deserialize("[1,2]")));
        System.out.println(codec.serialize(codec.deserialize("[1,2]"))
                .equals("[1,2]"));

        System.out.println(codec.serialize(codec.deserialize("[5,2,3,null,null,2,4,3,1]")));
        System.out.println(codec.serialize(codec.deserialize("[5,2,3,null,null,2,4,3,1]"))
                .equals("[5,2,3,null,null,2,4,3,1]"));


    }
}
