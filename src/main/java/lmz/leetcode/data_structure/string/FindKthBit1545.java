package lmz.leetcode.data_structure.string;

public class FindKthBit1545 {
    /**
     leetcode:递归
     */
    class Solution {
        public char findKthBit(int n, int k) {
            if (k == 1) {
                return '0';
            }
            int tail = 1 << n;
            if (k == tail) {
                return '1';
            }
            int mid = 1 << (n - 1);
            if (k == mid) {
                return '1';
            } else if (k < mid) {
                return findKthBit(n - 1, k);
            } else {
                k = mid * 2 - k;
                return invert(findKthBit(n - 1, k));
            }
        }

        public char invert(char bit) {
            return (char) ('0' + '1' - bit);
        }
    }

    /**
     * 暴力模拟
     */
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        //每次形成第n个值时，值都是不变的
        while (sb.length() < k) {
            int i = sb.length() - 1;
            sb.append("1");
            while (i >= 0) {
                char c = sb.charAt(i--) == '1' ? '0' : '1';
                sb.append(c);
            }
        }
        return sb.charAt(k - 1);
    }

    /**
     * my：模拟 20!太大了
     */
    public char findKthBit1(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 0; i < n; i++) {
            sb.append('1');
            for (int j = sb.length() - 2; j >= 0; j--) {
                if (sb.charAt(j) == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
        }
        System.out.println(sb);
        //k从1开始记数
        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        FindKthBit1545 findKthBit1545 = new FindKthBit1545();
        System.out.println(findKthBit1545.findKthBit(2, 3));
    }
}
