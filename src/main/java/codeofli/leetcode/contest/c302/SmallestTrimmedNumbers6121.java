package codeofli.leetcode.contest.c302;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestTrimmedNumbers6121 {
    /**
     * 数据量不大，直接模拟
     * 1 <= nums.length <= 100
     * 1 <= nums[i].length <= 100  ，注意字符数字长度可能超过int
     * nums[i] 只包含数字。
     * 所有 nums[i].length 的长度 相同 。
     */
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int index = 0;
        int len = nums.length;
        int strLen = nums[0].length();
        for (int[] query : queries) {
            String[] temp = new String[len];
            //int[] number = new int[len];
            for (int i = 0; i < len; i++) {
                temp[i] = nums[i].substring(strLen - query[1]);
                //number[i] = Integer.parseInt(temp[i]);
            }
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((pair1, pair2) -> {
                if (pair2.s.equals(pair1.s)) {
                    return pair2.index- pair1.index; //下标 更小 的数字视为更小的数字
                }
                return pair2.s.compareTo(pair1.s);
            });
            int k = query[0];
            for (int i = 0; i < k; i++) {
                maxHeap.add(new Pair(temp[i],i));
            }
            for (int i = k; i < len; i++) {
                if (temp[i].compareTo(maxHeap.peek().s) < 0 ) {
                    maxHeap.poll();
                    maxHeap.add(new Pair(temp[i],i));
                }
            }
            res[index++] = maxHeap.peek().index;
        }
        return res;
    }

    class Pair{
        String s;
        int index;

        Pair(String s,int index){
            this.s = s;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        SmallestTrimmedNumbers6121 smallestTrimmedNumbers6121 = new SmallestTrimmedNumbers6121();
        testCase(smallestTrimmedNumbers6121, "[\"102\",\"473\",\"251\",\"814\"]", "[[1,1],[2,3],[4,2],[1,2]]", "[2,2,1,0]");

        testCase(smallestTrimmedNumbers6121, "[\"24\",\"37\",\"96\",\"04\"]", "[[2,1],[2,2]]", "[3, 0]");
        //
        //
        testCase(smallestTrimmedNumbers6121, "[\"64333639502\",\"65953866768\",\"17845691654\",\"87148775908\",\"58954177897\",\"70439926174\",\"48059986638\"," +
                "\"47548857440\",\"18418180516\",\"06364956881\",\"01866627626\",\"36824890579\",\"14672385151\",\"71207752868\"]",
                "[[9,4],[6,1],[3,8],[12,9],[11,4],[4,9],[2,7],[10,3],[13,1],[13,1],[6,1],[5,10]]", "[3, 0]");
    }

    private static void testCase(SmallestTrimmedNumbers6121 smallestTrimmedNumbers6121, String original, String original1, String original2) {
        System.out.println(Arrays.toString(smallestTrimmedNumbers6121.smallestTrimmedNumbers(StringTransformUtil.toStringArray(original),
                StringTransformUtil.toIntMatrix(original1))));
        System.out.println(Arrays.equals(smallestTrimmedNumbers6121.smallestTrimmedNumbers(StringTransformUtil.toStringArray(original),
                StringTransformUtil.toIntMatrix(original1)), StringTransformUtil.toIntArray(original2)));
    }
}
