package mars.leetcode.binary_tree.summary;

import mars.leetcode.binary_tree.TreeNode;

import java.net.InterfaceAddress;
import java.util.LinkedList;
import java.util.Queue;

public class EncodeTree297 {

    class MySolution {
        /**
         * 提示: 输入输出格式与 LeetCode 目前使用的方式一致.。
         * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
         * 思路：层次遍历
         *
         * @param root
         * @return
         */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            int nullValue = 2022; //补充结点的值
            while (!queue.isEmpty()) {
                int size = queue.size();
                System.out.println(sb);
                System.out.println(queue.size());
                for (int i = 0; i < size; i++) {
                    root = queue.poll();
                    if (root.val == nullValue) { //补充结点，之前为null
                        continue;
                    }
                    if (root.left != null) {
                        queue.add(root.left);
                    } else {
                        queue.add(new TreeNode(nullValue));//补充结点
                    }
                    if (root.right != null) {
                        queue.add(root.right);
                    } else {
                        queue.add(new TreeNode(nullValue));//补充结点
                    }
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            System.out.println(sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1, data.length() - 1);
            String[] split = data.split(",");
            if (split.length <= 0) {
                return null;
            }
            TreeNode[] nodes = new TreeNode[split.length];
            if ("null".equals(split[0])) {
                return null;
            }
            nodes[0] = new TreeNode(Integer.parseInt(split[0]));
            //nodes[0].val = Integer.parseInt(split[0]);
            int depth = 1;
            int start = 0;
            int nextStart = 0;

            for (int i = 1; i < split.length; ) {
                int levelSize = 1 << (depth - 1);
                start = nextStart;
                nextStart = start + levelSize;
                System.out.println("start：" + start + ",nextStart:" + nextStart);
                for (int j = start; j < nextStart; j++) {
                    if ("null".equals(split[j])) {
                        continue;
                    }
                    //TreeNode tmp = null;
                    if (!"null".equals(split[i])) {
                        nodes[i] = new TreeNode(Integer.parseInt(split[i]));
                    }
                    nodes[j].left = nodes[i++];
                    //TreeNode tmp = null;
                    if (!"null".equals(split[i])) {
                        nodes[i] = new TreeNode(Integer.parseInt(split[i]));
                    }
                    nodes[j].right = nodes[i++];
                }
            }
            return nodes[0];
        }
    }

    /**
     * 自动义编码格式，如dfs遍历的格式
     * 前序遍历，中左右
     */
    public class LeetCodeDfsSolution {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serializeDfs(root, new StringBuilder());
        }

        public String serializeDfs(TreeNode cur, StringBuilder sb) {
            if (cur == null) {
                sb.append("null,");
                return null;
            }
            sb.append(cur.val + ",");
            serializeDfs(cur.left, sb);
            serializeDfs(cur.right, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // System.out.println(data);
            if (data == null || "null".equals(data)) { //空树
                return null;
            }
            String[] split = data.split(",");
            //TreeNode root = getNode(split[0]);
            //if(root == null) return null;
            return deserializeDfs(split);
            //return root;
        }

        int idx;

        public TreeNode deserializeDfs(String[] data) {
            String value = data[idx];
            // System.out.println(idx+","+value);
            if ("null".equals(value)) {
                return null;
            }
            TreeNode cur = new TreeNode(Integer.parseInt(value));
            idx++;
            cur.left = deserializeDfs(data);
            idx++;
            cur.right = deserializeDfs(data);
            return cur;
        }
    }

    /**
     * 方法二：括号表示编码 + 递归下降解码
     */
    public static class Solution3 {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "X";
            }
            return "(" + serialize(root.left) + ")" + root.val
                    + "(" + serialize(root.right) + ")";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.println(data);
            char[] chars = data.toCharArray();
            //Integer cnt = Integer.valueOf(0);
            int[] cnt ={0};
            return parse(chars,cnt);
        }
        //int cnt = 0;
        public TreeNode parse(char[] chars,int[] cnt) {
            if (cnt[0] >= chars.length || chars[cnt[0]] == 'X') {
                cnt[0]++;
                return null;
            }
            System.out.println("cnt:"+cnt[0]+",value:"+chars[cnt[0]]);
            TreeNode cur = new TreeNode(0); //默认设置为0；
            cur.left = parseSubTree(chars,cnt);
            cur.val = parseInt(chars,cnt);
            cnt[0]++;
            cur.right =parseSubTree(chars,cnt);
            return cur;
        }

        public TreeNode parseSubTree(char[] chars,int[] cnt){
            //System.out.println("cnt:"+cnt+",value:"+chars[cnt]);
            cnt[0]++; //左括号
            System.out.println("cnt:"+cnt[0]+",value:"+chars[cnt[0]]);
            TreeNode cur =parse(chars,cnt);
            cnt[0]++; //右括号
            return cur;
        }
        public int parseInt(char[] chars, int[] ptr) {
            int x = 0, sgn = 1;
            if (!Character.isDigit(chars[ptr[0]])) {
                sgn = -1;
                ++ptr[0];
            }
            while (Character.isDigit(chars[ptr[0]])) {
                x = x * 10 + chars[ptr[0]++] - '0';
            }
            return x * sgn;
        }

    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3
                .deserialize("((X)2(X))1(((X)4(X))3((X)5(X)))");
    }
}
