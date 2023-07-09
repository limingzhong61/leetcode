package com.lmz.algorithm.graph.character;

import com.lmz.my.leetcode.TransformUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class IsBipartite785 {

    /**
     * leetcode: 可能的二分
     * 深度优先搜索+二分着色判断
     *我们要检查这个图的每个连通分支是否为二分的。
     * 对于每个连通的部分，我们只需试着用两种颜色对它进行着色，就可以检查它是否是二分的。
     * 如何做到这一点：将任一结点涂成红色，然后将它的所有邻居都涂成蓝色，然后将所有的邻居的邻居都涂成红色，
     * 以此类推。如果我们将一个红色结点涂成蓝色（或蓝色结点涂成红色），那么就会产生冲突。
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //两者颜色可以用布尔值，如true-red,false-blue
        Map<Integer, Boolean> colorMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!colorMap.containsKey(i)) { //没有着色
                if (!dfs(graph, colorMap, i, true)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, Map<Integer, Boolean> colorMap, int u, boolean nextColor) {
        if (colorMap.containsKey(u)) {//如果下一个结点已经标记过，则检查颜色是否冲突
            return colorMap.get(u) == nextColor;
        }
        colorMap.put(u, nextColor);
        for (var nextVertex : graph[u]) {
            if (!dfs(graph, colorMap, nextVertex, !nextColor)) { //相邻的点，需要颜色不同
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsBipartite785 isBipartite785 = new IsBipartite785();

        System.out.println(isBipartite785.isBipartite(TransformUtil.toIntMatrix("[[1,2,3],[0,2],[0,1,3],[0,2]]")));
        System.out.println((String.valueOf(isBipartite785.isBipartite(TransformUtil.toIntMatrix(
                "[[1,2,3],[0,2],[0,1,3],[0,2]]")) == false).toUpperCase(Locale.ROOT)));
        System.out.println(isBipartite785.isBipartite(TransformUtil.toIntMatrix("[[1,3],[0,2],[1,3],[0,2]]")));
        System.out.println((String.valueOf(isBipartite785.isBipartite(TransformUtil.toIntMatrix(
                "[[1,3],[0,2],[1,3],[0,2]]")) == true).toUpperCase(Locale.ROOT)));
    }
}
