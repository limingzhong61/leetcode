package com.lmz.algorithm_practice.dp;

import java.util.Arrays;

public class MaxHeight1691 {
    public int maxHeight(int[][] cuboids) {
        for (var cube : cuboids) {
            Arrays.sort(cube);
        }
        Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int n = cuboids.length;
        var f = new int[n];
        f[0] = cuboids[0][2];
        int res = 0;
        for(int i = 1; i < n; i++){
            f[i] = cuboids[i][2];
            for(int j = 0; j < i; j++){
                // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
                if(cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]){
                    f[i] = Math.max(f[i],f[j] + cuboids[j][2]);
                }
            }
            System.out.printf("%d\n",f[i]);
            res = Math.max(res,f[i]);
        }

        return  res;
    }
}
