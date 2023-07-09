package com.lmz.algorithm.graph.find_circle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-06-22 11:30
 */
public class CanFinish207 {

    //public boolean canFinish(int numCourses, int[][] prerequisites) {
    //    // 将有向图的边集合转换为有向图邻接表
    //    ArrayList<Integer>[] adj = toAdjDirectedGraph(prerequisites, numCourses);
    //    //
    //    UnionFind unionFind = new UnionFind(numCourses);
    //    for(int[] edge :prerequisites){
    //        unionFind.union(, , )
    //    }
    //}


    /**
     * 将有向图的边集合转换为有向图邻接表
     * @param edges 无向图的边集合 其中 edges[i][0] --> edges[i][1]
     * @param n
     * @return  邻接表
     */
    public static ArrayList<Integer>[] toAdjDirectedGraph(int[][] edges, int n){
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(var x : adj){
            x = new ArrayList<Integer>();
        }
        for(var x : edges){
            adj[x[0]].add(x[1]);
        }
        return adj;
    }
    class UnionFind {
        private int count; //记录连通分量
        private int[] parent; //节点x的根节点是parent[x]
        //size数组记录每个根结点的结点数
        int[] size;

        public UnionFind(int n) {
            //一开始互不相通
            this.count = n;
            //一开始，每个节点是自己的父节点
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /*
        将p和q连接, 如果两个节点被连通，那么则让其中的一个根节点连接到另一个节点的根节点上
        */
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return false;
            }
            //将size大的归结到rootP上
            if(size[rootP]< size[rootQ]){
                int temp = rootP;
                rootP = rootQ;
                rootQ = temp;
            }
            //将数量较小的根结点rootQ归结到数量较大的根结点rootP上
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            count--; //两个分量合二为一
            return  true;
        }
        /**
         * 返回某个节点x的根节点
         * 带路径压缩的查找：因为带路径压缩所以不用担心栈溢出。
         */
        public int find(int x){
            return parent[x] == x ? x : (parent[x] = find(parent[x])); //路径压缩
        }



        /*
         判断p和q是否连通:如果两个节点是连通的，那么他们一定拥有相同的根节点
         */
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        /*
        返回具体有多少个连通分量
         */
        public int count() {
            return count;
        }


        ////返回某个节点x的根节点
        //private int find(int x) {
        //    //根节点的parent[x]==x
        //    while (parent[x] != x) {
        //        x = parent[x];
        //    }
        //    return x;
        //}
    }

}
