package lmz.util.solution_template.graph.util;

import java.util.ArrayList;

/**
 * @author: limingzhong
 * @create: 2023-06-09 9:49
 */
public class GraphUtil {

    /**
     * 将无向图的边集合转换为 邻接表
     * @param edges 无向图的边集合
     * @param n
     * @return  邻接表
     */
    public static ArrayList<Integer>[] toAdjInUndirectedGraph(int[][] edges,int n){
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(var x : adj){
            x = new ArrayList<Integer>();
        }
        for(var x : edges){
            adj[x[0]].add(x[1]);
            adj[x[1]].add(x[0]);
        }
        return adj;
    }


    /**
     * 将有向图的边集合转换为有向图邻接表
     * @param edges 无向图的边集合 其中 edges[i][0] --> edges[i][1]
     * @param n
     * @return  邻接表
     */
    public static ArrayList<Integer>[] toAdjDirectedGraph(int[][] edges,int n){
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(var x : adj){
            x = new ArrayList<Integer>();
        }
        for(var x : edges){
            adj[x[0]].add(x[1]);
        }
        return adj;
    }
}
