package com.lmz.leetcode.practice.contest.old;

import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;
import com.lmz.algorithm_learning.leetcode.LinkedList;
import com.lmz.algorithm_learning.util.matrix.MatrixUtil;
//Definition for singly-linked list.
// class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

public class SpiralMatrix6111 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int left = 0, right = n - 1, top = 1, bottom = m - 1;
        int i = -1, j = -1;

        while (true) {
            // 右移
            for (i++,j++; j <= right; j++) {
                int val = -1;
                if (head != null) {
                    val = head.val;
                    head = head.next;
                }
                res[i][j] = val;
            }
            right--;
            if (top > bottom && j > right) {
                break;
            }
            //下移
            for (j--,i++; i <= bottom; i++) {
                int val = -1;
                if (head != null) {
                    val = head.val;
                    head = head.next;
                }
                res[i][j] = val;
            }
            bottom--;
            if (i > bottom && left > right) {
                break;
            }

            //左移
            for (i--,j--; j >= left; j--) {
                int val = -1;
                if (head != null) {
                    val = head.val;
                    head = head.next;
                }
                res[i][j] = val;
            }
            left++;
            if (top > bottom && left > j) {
                break;
            }

            //上移
            for (j++,i--; i >= top; i--) {
                int val = -1;
                if (head != null) {
                    val = head.val;
                    head = head.next;
                }
                res[i][j] = val;
            }
            top++;
            if (top > i && left > right) {
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        SpiralMatrix6111 spiralMatrix6111 = new SpiralMatrix6111();
        MatrixUtil.printMatrix(spiralMatrix6111.spiralMatrix(3, 5, LinkedList.StrToLinkedList2("[3,0,2,6,8,1,7,9,4,2,5,5,0]")));
    }
}
