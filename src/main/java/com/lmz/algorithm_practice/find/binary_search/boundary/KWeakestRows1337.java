package com.lmz.algorithm_practice.find.binary_search.boundary;

import java.util.Arrays;
import java.util.Objects;

public class KWeakestRows1337 {
    /**
     * 统计后排序
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        //2 <= n, m <= 100
        int m = mat.length, n = mat[0].length;
        Pair<Integer, Integer>[] pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mat[i][mid] == 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                pairs[i] = new Pair<>(i, low);
            }
        }
        Arrays.sort(pairs, (a, b) -> {
            if (Objects.equals(a.val2, b.val2)) {
                return a.val1 - b.val1;
            }
            return a.val2 - b.val2;
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pairs[i].val1;
        }
        return res;
    }

    public class Pair<V1, V2> {
        public V1 val1;
        public V2 val2;

        public Pair() {
        }

        public Pair(V1 val1, V2 val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
}
