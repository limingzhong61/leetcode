package codeofli.leetcode.graph_theory;

import codeofli.my.leetcode.TransformUtil;

public class MakeConnected1319 {
    /**
     * 并查集
     */
    private int count; //记录连通分量
    private int[] parent; //节点x的根节点是parent[x]

    public int makeConnected(int n, int[][] connections) {
        int edgeCnt = connections.length;
        //无向图变成连通图至少需要n-1条边
        if(edgeCnt < n -1){
            return -1;
        }
        //一开始互不相通
        this.count = n;
        //一开始，每个节点是自己的父节点
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < edgeCnt;i++){
            union(connections[i][0],connections[i][1]);
        }
        return this.count - 1;
    }


    /*
    将p和q连接, 如果两个节点被连通，那么则让其中的一个根节点连接到另一个节点的根节点上
    */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        //将两颗树合并为一颗
        parent[rootP] = rootQ; //parent[rootQ]=rootP 效果是一样的
        count--; //两个分量合二为一
    }

    /**
     * 返回某个节点x的根节点
     * 带路径压缩的查找：因为带路径压缩所以不用担心栈溢出。
     */
    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); //路径压缩
    }

    public static void main(String[] args) {
        MakeConnected1319 makeConnected1319 = new MakeConnected1319();

        testCase(makeConnected1319,4,"[[0,1],[0,2],[1,2]]",1);
        testCase(makeConnected1319,6,"[[0,1],[0,2],[0,3],[1,2],[1,3]]",2);
        testCase(makeConnected1319,6,"[[0,1],[0,2],[0,3],[1,2]]",-1);
        testCase(makeConnected1319,5,"[[0,1],[0,2],[3,4],[2,3]]",0);
    }

    private static void testCase(MakeConnected1319 makeConnected1319, int p1, String p2, int res) {
        System.out.println(makeConnected1319.makeConnected(
                p1, TransformUtil.toIntMatrix(p2)));
        System.out.println(makeConnected1319.makeConnected(
                p1, TransformUtil.toIntMatrix(p2)) == res);
    }
}
