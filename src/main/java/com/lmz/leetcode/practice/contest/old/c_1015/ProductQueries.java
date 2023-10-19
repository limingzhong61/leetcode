package com.lmz.leetcode.practice.contest.old.c_1015;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductQueries {
    public int[] productQueries1(int n, int[][] queries) {
        List<Integer> temp = new ArrayList<>();
        int k = n;
        while(k > 0){
            if(k == 2){
                temp.add(2);
                break;
            }
            int tempK = k / 2;
            //先上取整
            if(tempK * 2 == k){
                temp.add(tempK );
                k -= tempK;
            }else {
                temp.add(tempK +1);
                k -= tempK + 1;
            }

        }
        final long MOD = (long)(10e9 + 7);
        int[] res = new int[queries.length];
        int idx = 0;
        Collections.reverse(temp);
        for(var query : queries){
            long product = 1;
            for(int i = query[0]; i <= query[1]; i++){
                product = (product * temp.get(i)) % MOD;

            }
            res[idx++] = (int) product;
        }
        return res;
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Long> temp = new ArrayList<>();
        int k = n;
        var p = new long[100];
        p[0] = 1;
        int pi = 1;
        for(; pi < n; pi++){
            p[pi] = p[pi - 1] * 2;
            if(p[pi] > n){
                break;
            }
        }
        for(int i = pi; i >= 0; i--){
            if(n == 0){
                break;
            }
            if(p[i] <= n){
                temp.add(p[i]);
                n -= p[i];
            }
        }
        final long MOD = (long)(1e9 + 7);
        int[] res = new int[queries.length];
        int idx = 0;
        Collections.reverse(temp);
        for(var query : queries){
            long product = 1;
            for(int i = query[0]; i <= query[1]; i++){
                product = (product % MOD * temp.get(i) % MOD) % MOD;
                System.out.println(product);
            }
            System.out.println("----------------------------");
            res[idx++] = (int) product;
        }
        return res;
    }

    public static void main(String[] args) {
        ProductQueries productQueries = new ProductQueries();
        //System.out.println(Arrays.toString(productQueries.productQueries(15, TransformUtil.toIntMatrix("[[0,1],[2,2],[0,3]]"))));
        //System.out.println(Arrays.toString(productQueries.productQueries(2, TransformUtil.toIntMatrix(" [[0,0]]"))));
        //System.out.println(Arrays.toString(productQueries.productQueries(4, TransformUtil.toIntMatrix(" [[0,0]]"))));
        //System.out.println(Arrays.toString(productQueries.productQueries(3, TransformUtil.toIntMatrix(" [[0,0]]"))));
        //System.out.println(Arrays.toString(productQueries.productQueries(13, TransformUtil.toIntMatrix("[[1,2],[1,1]]"))));
        System.out.println(Arrays.toString(productQueries.productQueries(919, TransformUtil.toIntMatrix("[[5,5],[4,4],[0,1],[1,5],[4,6],[6,6],[5,6],[0,3],[5,5],[5,6],[1,2],[3,5],[3,6],[5,5],[4,4],[1,1],[2,4],[4,5],[4,4],[5,6],[0,4],[3,3],[0,4],[0,5],[4,4],[5,5],[4,6],[4,5],[0,4],[6,6],[6,6],[6,6],[2,2],[0,5],[1,4],[0,3],[2,4],[5,5],[6,6],[2,2],[2,3],[5,5],[0,6],[3,3],[6,6],[4,4],[0,0],[0,2],[6,6],[6,6],[3,6],[0,4],[6,6],[2,2],[4,6]]"))));
    }
}
