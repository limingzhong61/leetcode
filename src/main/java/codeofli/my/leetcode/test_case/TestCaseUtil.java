package codeofli.my.leetcode.test_case;

import codeofli.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestCaseUtil {
    /**
     * leetcode: 可能的二分
     * 深度优先搜索+二分着色判断
     * 考虑由给定的 “不喜欢” 边缘形成的 N 人的图表。我们要检查这个图的每个连通分支是否为二分的。
     *
     * 对于每个连通的部分，我们只需试着用两种颜色对它进行着色，就可以检查它是否是二分的。
     * 如何做到这一点：将任一结点涂成红色，然后将它的所有邻居都涂成蓝色，然后将所有的邻居的邻居都涂成红色，
     * 以此类推。如果我们将一个红色结点涂成蓝色（或蓝色结点涂成红色），那么就会产生冲突。
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //边的集合转换为邻接表,从1开始
        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 0; i <= n; ++i) {
            adjList[i] = new ArrayList<>();
        }
        for (var edge : dislikes) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        //两者颜色可以用布尔值，如true-red,false-blue
        Map<Integer,Boolean> colorMap  = new HashMap<>();
        for(int i = 1; i <= n; i++){
            if(!colorMap.containsKey(i)){ //没有着色
                if(!dfs(adjList,colorMap,i,true)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] adjList, Map<Integer, Boolean> colorMap, int u,boolean nextColor) {
        if(colorMap.containsKey(u)){//如果下一个结点已经标记过，则检查颜色是否冲突
            return colorMap.get(u) == nextColor;
        }
        colorMap.put(u,nextColor);
        for(var nextVertex : adjList[u]){
            if(!dfs(adjList,colorMap,nextVertex,!nextColor)){ //相邻的点，需要颜色不同
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TestCaseUtil possibleBipartition886 = new TestCaseUtil();

        testCase(possibleBipartition886, 4, "[[1,2],[1,3],[2,4]]", true);
        testCase(possibleBipartition886, 3, " [[1,2],[1,3],[2,3]]", false);
        testCase(possibleBipartition886, 5, "[[1,2],[2,3],[3,4],[4,5],[1,5]]", false);
        testCase(possibleBipartition886, 10, "[[4,7],[4,8],[5,6],[1,6],[3,7],[2,5],[5,8]," +
                "[1,2],[4,9],[6,10],[8,10],[3,6],[2,10],[9,10],[3,9],[2,3],[1,9],[4,6],[5,7],[3,8],[1,8],[1,7],[2,4]]",
                true);
        testCase(possibleBipartition886, 3, "[[1,2],[1,3],[2,3]]", false);
        testCase(possibleBipartition886, 4, "[[1,2],[3,4],[1,3],[1,4]]", false);
        testCase(possibleBipartition886, 10, "[[4,7],[4,8],[5,6],[1,6],[3,7],[2,5],[5,8],[1,2],[4,9],[6,10],[8,10]" +
                ",[3,6],[2,10],[9,10],[3,9],[2,3],[1,9],[4,6],[5,7],[3,8],[1,8],[1,7],[2,4]]", true);
    }

    private static void testCase(TestCaseUtil possibleBipartition886, int i, String s, boolean b) {
        System.out.println(possibleBipartition886.possibleBipartition(i,
                TransformUtil.toIntMatrix(s)));
        System.out.println(String.valueOf(possibleBipartition886.possibleBipartition(i,
                TransformUtil.toIntMatrix(s)) == b).toUpperCase(Locale.ROOT));
        if(possibleBipartition886.possibleBipartition(i,
                TransformUtil.toIntMatrix(s)) != b){
            // Declaring ANSI_RESET so that we can reset the color
             final String ANSI_RESET = "\u001B[0m";
            // Declaring the background color
             final String ANSI_RED_BACKGROUND
                    = "\u001B[41m";
            System.out.println(i+","+s+",b");
            System.out.println(ANSI_RED_BACKGROUND
                    + "ERROR ANSWER"
                    + ANSI_RESET);
        }
        //没有，err在最后才输出
        //System.err.println(String.valueOf(possibleBipartition886.possibleBipartition(i,
        //        TransformUtil.toIntMatrix(s)) == b).toUpperCase(Locale.ROOT));
    }
}
