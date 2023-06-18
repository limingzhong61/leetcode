//package lmz.algorithm.contest.c350;
//
//import lmz.my.leetcode.TransformUtil;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * @author: limingzhong
// * @create: 2023-06-18 10:52
// */
//public class PaintWalls {
//    class Pair {
//        int cost;
//        int time;
//
//        Pair(int cost, int time) {
//            this.cost = cost;
//            this.time = time;
//        }
//    }
//
//    public int paintWalls(int[] cost, int[] time) {
//        int n = cost.length;
//        // 每次取收益最大的
//        ArrayList<Pair> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(new Pair(cost[i], time[i]));
//        }
//        while (list.size() > 0){
//            for(int i = 0; i < list.size(); i++){
//
//            }
//        }
//    }
//
//    class Solution {
//
//
//        public int paintWalls(int[] cost, int[] time) {
//            int n = cost.length;
//            Pair[] pairs = new Pair[n];
//            for (int i = 0; i < n; i++) {
//                pairs[i] = new Pair(cost[i], time[i]);
//            }
//            Arrays.sort(pairs, (a, b) -> {
//                if (a.cost == b.cost) {
//                    return b.time - a.time;
//                }
//                return a.cost - b.cost;
//            });
//            int ans = 0;
//            int len = n;
//            for (int i = 0; i < len; i++) {
//                ans += pairs[i].cost;
//                len -= pairs[i].time;
//            }
//            return ans;
//        }
//    }
//
//    public static void main(String[] args) {
//        PaintWalls paintWalls = new PaintWalls();
//        testCase(paintWalls, "[26,53,10,24,25,20,63,51]", "[1,1,1,1,2,2,2,1]", 55);
//        testCase(paintWalls, "[49,35,32,20,30,12,42]", "[1,1,2,2,1,1,2]", 62);
//
//    }
//
//    private static void testCase(PaintWalls paintWalls, String original, String original1, int x) {
//        System.out.println(paintWalls.paintWalls(TransformUtil.toIntArray(original
//        ), TransformUtil.toIntArray(original1)));
//        System.out.println(paintWalls.paintWalls(TransformUtil.toIntArray(original
//        ), TransformUtil.toIntArray(original1)) == x);
//    }
//}
