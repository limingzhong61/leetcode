package lmz.algorithm.graph.traverse;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class ShortestPathLength847 {
    /**
     * leetcode:
     * 状态压缩 + 广度优先搜索
     * path 是一个长度为 n 的二进制数，表示每一个节点是否经过。
     * 如果 path 的第 i 位是 1，则表示节点 i 已经过，否则表示节点 i 未经过；
     * bfs先到达的一定更优,这个常识,因为水波式扩散
     * save[v][mask_v]记录的是跑到v节点时状态为mask_v(通过状压记录状态,如果某个节点跑到过就让mask_v对应二进制位为1),
     * 而!save[v][mask_v]则是看对于跑到当前节点v状态为mask_v的情况之前是否发生过,根据性质1,
     * 如果之前发生过,那么肯定之前的更优(准确说是不会更劣),那么用之前那个就可以,那当前这个情况就可以忽略了(这个也保证了不会绕圈圈)
     */
    public int shortestPathLength(int[][] graph) {
        //1 <= n <= 12
        int n = graph.length;
        boolean[][] seen = new boolean[n][1 << n];
        //<v,path,dist>
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            //所有起点
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0],path = tuple[1],dist = tuple[2];
            //是否走完所有的点。
            if(path  == (1 << n) - 1){
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 path 的第 v 位置为 1,即将v加入path，看是否已经有过这种情况
                int pathV = path | (1 << v);
                if (!seen[v][pathV]) {
                    seen[v][pathV] = true; //标记访问
                    queue.add(new int[]{v,pathV,dist+1});
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ShortestPathLength847 shortestPathLength847 = new ShortestPathLength847();

        System.out.println(shortestPathLength847.shortestPathLength(TransformUtil.toIntMatrix("[[1,2,3],[0],[0],[0]]")));
        System.out.println(shortestPathLength847.shortestPathLength(TransformUtil.toIntMatrix("[[1,2,3],[0],[0],[0]]")) == 4);

        System.out.println(shortestPathLength847.shortestPathLength(TransformUtil.toIntMatrix(" [[1],[0,2,4],[1,3,4],[2],[1,2]]")));
        System.out.println(shortestPathLength847.shortestPathLength(TransformUtil.toIntMatrix(" [[1],[0,2,4],[1,3,4],[2],[1,2]]")) == 4);
    }


}
