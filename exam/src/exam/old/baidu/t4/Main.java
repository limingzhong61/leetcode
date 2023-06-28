//<<<<<<< HEAD
//package meituan.t4;
//=======
//package baidu.t4;
//>>>>>>> f0707b453829379a33caafde07df465824c3cc1b
////package main
////注意不要添加包名称，否则会报错。
//
//import java.util.Scanner;
//
//public class exam.Main {
//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        int n, m, k;
//        while (cin.hasNextInt()) {
//            n = cin.nextInt();
//            m = cin.nextInt();
//            k = cin.nextInt();
//<<<<<<< HEAD
//            boolean[][] map = new boolean[n + 1][m + 1];
//            int[][] ks = new int[k][2];
//            int minLen = Integer.MAX_VALUE;
//            for (int i = 0; i < k; i++) {
//                ks[i][0] = cin.nextInt();
//                ks[i][1] = cin.nextInt();
//                map[ks[i][0]][ks[i][1]] = true;
//            }
//            int x1, x2, y1, y2;
//            x1 = cin.nextInt();
//            y1 = cin.nextInt();
//            x2 = cin.nextInt();
//            y2 = cin.nextInt();
//
//            for (int i = 0; i < k; i++) {
//                minLen = getMinLen(minLen, x1, y1, ks[i]);
//                minLen = getMinLen(minLen, x2, y2, ks[i]);
//            }
//            System.out.println(minLen);
//        }
//    }
//
//    private static int getMinLen(int minLen, int x1, int y1, int[] ks) {
//        int a = Math.abs(x1 - ks[0]);
//        int b = Math.abs(y1 - ks[1]);
//        minLen = Math.min(minLen, a + b);
//        return minLen;
//    }
//=======
//        }
//    }
//
//>>>>>>> f0707b453829379a33caafde07df465824c3cc1b
//}
