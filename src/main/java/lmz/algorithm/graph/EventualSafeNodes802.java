package lmz.algorithm.graph;

import lmz.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualSafeNodes802 {
    /**
     * leetcode:深度优先搜索 + 三色标记法
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (safe(graph,color,i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean safe(int[][] graph, int[] color, int x) {
        if(color[x] > 0){
            return color[x] == 2;
        }
        color[x] = 1;
        for(int item : graph[x]){
            if(!safe(graph,color,item)){
                return false;
            }
        }
        color[x] = 2; //正常遍历结束；
        return true;
    }

    /**
     * 我理解的题目意思是：一条边不能重复经过一个点然后到达终端结点，才算一条通向终端结点的边
     */
    boolean[] safe;
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        int len = graph.length;
        safe = new boolean[len];
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (graph[i].length == 0) {
                safe[i] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            Arrays.fill(visited,false);
            if (graph[i].length != 0) {
                safe[i] = dfs(i, graph, visited);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (safe[i])
                res.add(i);
        }
        return res;
    }

    private boolean dfs(int i, int[][] graph, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < graph[i].length; j++) {
            //下一个节点已经加入safe
            if(safe[graph[i][j]]){
                continue;
            }
            if (!visited[graph[i][j]]) {
                if (!dfs(graph[i][j], graph, visited)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        //正常结束,标记当前i为safe
        return safe[i] = true;
    }

    public static void main(String[] args) {
        EventualSafeNodes802 eventualSafeNodes802 = new EventualSafeNodes802();

        testCase(eventualSafeNodes802, "[[1,2],[2,3],[5],[0],[5],[],[]]", "[2,4,5,6]");
        testCase(eventualSafeNodes802, "[[1,2,3,4],[1,2],[3,4],[0,4],[]]", "[4]");
        testCase(eventualSafeNodes802, "[[],[0,2,3,4],[3],[4],[]]", "[0,1,2,3,4]");
        testCase(eventualSafeNodes802, "[[1,2,3,4],[1,2,3,4],[3,4],[4],[]]", "[2,3,4]");

    }

    private static void testCase(EventualSafeNodes802 eventualSafeNodes802, String s, String s2) {
        System.out.println(eventualSafeNodes802.eventualSafeNodes(TransformUtil.toIntMatrix(s)));
        System.out.println(eventualSafeNodes802.eventualSafeNodes(TransformUtil.toIntMatrix(s)).equals(
                TransformUtil.toArrayList(s2)));
    }
}
