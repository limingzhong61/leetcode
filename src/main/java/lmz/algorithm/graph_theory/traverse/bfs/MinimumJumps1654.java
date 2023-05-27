package lmz.algorithm.graph_theory.traverse.bfs;

import lmz.my.leetcode.TransformUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumps1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        //1 <= arr.length <= 5 * 10^4
        int n = forbidden.length;
        //BFS
        Set<Integer> visited = new HashSet<>();
        for(int item : forbidden){
            visited.add(item);
        }
        //<v,jumpCnt,backJump>
        Queue<int[]> queue = new LinkedList<>();
        // 0 出发
        queue.add(new int[]{0, 0, 0});
        visited.add(0);
        if (0 == x) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int[] triple = queue.poll();
            int loc = triple[0], jumpCnt = triple[1], backJump = triple[2];
            //它不能 连续 往后跳 2 次。
            int w = loc - b;
            if (backJump != 1 && w >= 0 && !visited.contains(w)) {
                if (w == x) {
                    return jumpCnt + 1;
                }
                visited.add(w); //标记访问
                queue.add(new int[]{w, jumpCnt + 1, 1});
            }
             w = loc + a;
            if (!visited.contains(w) ) {
                //回不去了
                //
                if(a > b && ( w >  x + b)){
                    continue;
                }else if( w >  x + a * b){
                    continue;
                }
                if (w == x) {
                    return jumpCnt + 1;
                }
                visited.add(w); //标记访问
                queue.add(new int[]{w, jumpCnt + 1, 0});
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumJumps1654 minimumJumps1654 = new MinimumJumps1654();

        testCase(minimumJumps1654, "[14,4,18,1,15]", 3, 15, 9, 3);

        testCase(minimumJumps1654, "[8,3,16,6,12,20]", 15, 13, 11, -1);
        testCase(minimumJumps1654, " [1,6,2,14,5,17,4]", 16, 9, 7, 2);
        testCase(minimumJumps1654, "[162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36," +
                "103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98]\n",
                29, 98, 80, 121);
    }

    private static void testCase(MinimumJumps1654 minimumJumps1654, String s, int i, int i2, int i3, int i4) {
        System.out.println(minimumJumps1654.minimumJumps(TransformUtil.
                toIntArray(s), i, i2, i3));
        System.out.println(minimumJumps1654.minimumJumps(TransformUtil.
                toIntArray(s), i, i2, i3) == i4);
    }
}
