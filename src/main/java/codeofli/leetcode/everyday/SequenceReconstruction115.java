package codeofli.leetcode.everyday;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.*;

public class SequenceReconstruction115 {
    /**
     * leetcode: 无环图拓扑排序
     * 其中 nums 是范围为 [1，n] 的整数的排列。
     * sequences[i] 是 nums 的一个子序列,不存在环
     */
    public boolean sequenceReconstruction115(int[] nums, int[][] sequences) {
        //1 <= n <= 10^4,
        int n = nums.length;
        //边的集合转换为邻接表,因为有可能有多个边重合，故用set判重，如[1,2,3],[2,3,4]都有[2,3]
        Set<Integer>[] adjList = new HashSet[n + 1];
        int[] inDegrees = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            adjList[i] = new HashSet<>();
        }
        for (int[] sequence : sequences) {
            for(int i = 1; i < sequence.length; i++){
                int prev = sequence[i-1],next = sequence[i];
                if (adjList[prev].add(next)) { //添加成功，入度+1
                    inDegrees[next]++;
                }

            }
        }
        //拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            if(size != 1){
                return false;
            }
            for (int i = 0; i < size; i++) {
                Integer u = queue.poll();
                for(var next : adjList[u]){
                    inDegrees[next]--;
                    if(inDegrees[next] == 0){
                        queue.add(next);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction115 sequenceReconstruction = new SequenceReconstruction115();
        System.out.println(sequenceReconstruction.sequenceReconstruction115(StringTransformUtil.toIntArray("[1,2,3]"),
                StringTransformUtil.toIntMatrix("[[1,2],[1,3]]")));
        System.out.println(sequenceReconstruction.sequenceReconstruction115(StringTransformUtil.toIntArray("[1,2,3]"),
                StringTransformUtil.toIntMatrix("[[1,2]]")));
        System.out.println(sequenceReconstruction.sequenceReconstruction115(StringTransformUtil.toIntArray("[1,2]"),
                StringTransformUtil.toIntMatrix("[[1,2]]")));
        System.out.println(sequenceReconstruction.sequenceReconstruction115(StringTransformUtil.toIntArray("[1,2,3]"),
                StringTransformUtil.toIntMatrix("[[1,2],[2,3]]")));

    }
}
