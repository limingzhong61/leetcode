package com.lmz.leetcode.practice.simulation;

public class ChampagneTower799 {
    /**
     * 模拟倒香槟过程。首先将所有的poured 杯香槟全部倒到 row=0 的这个杯子中。
     * 当有溢出时，再将溢出的部分平均倒到下一层的相邻的两个杯子中。
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double volume = row[j];
                if (volume > 1) {
                    nextRow[j] += (volume - 1) / 2;
                    nextRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = nextRow;
        }
        return Math.min(1, row[query_glass]);
    }
}
