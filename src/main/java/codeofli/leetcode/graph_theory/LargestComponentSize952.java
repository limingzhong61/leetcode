package codeofli.leetcode.graph_theory;


import codeofli.my.leetcode.StringTransformUtil;

import java.util.Arrays;

public class LargestComponentSize952 {
    /**
     * leetcode: 并查集
     * 对于范围[2，根号n]内的每个正整数 i，
     * 如果 i 是 num 的因数，则 num 和 i、num/i都属于同一个组件。
     */
    public int largestComponentSize(int[] nums) {
        //    1 <= nums.length <= 2 * 104
        int m = Arrays.stream(nums).max().getAsInt();
        UnionFind uf = new UnionFind(m + 1);
        for(int num : nums){
            for(int i  =2; i*i <= num; i++){
                if(num % i == 0){
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] cnt = new int[m+1];
        int res = 0;
        for(int num : nums){
            int root = uf.find(num);
            cnt[root]++;
            res = Math.max(res,cnt[root]);
        }
        return res;
    }

    /**
     * 并查集模板
     * 此模板增加了size数组记录每个根结点的结点数。(size数组可以删除，代码实现更简单，但是运行速度会变慢)
     * 将数量较小的根结点rootQ归结到数量较大的根结点rootP上，便于减小查找时的深度，加快查找速度。
     * @author LiMingzhong
     *
     */
    public class UnionFind {
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


        //返回某个节点x的根节点
        //public int find(int x) {
        //    //根节点的parent[x]==x
        //    while (parent[x] != x) {
        //        x = parent[x];
        //    }
        //    return x;
        //}
    }
    public static void main(String[] args) {
        LargestComponentSize952 largestComponentSize952 = new LargestComponentSize952();
        System.out.println(largestComponentSize952.largestComponentSize(StringTransformUtil.toIntArray("[4,6,15,35]")));
    }
}
