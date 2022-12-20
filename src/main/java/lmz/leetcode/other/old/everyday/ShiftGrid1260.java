package lmz.leetcode.other.old.everyday;

import lmz.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //1 <= m <= 50,1 <= n <= 50
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k = k % total;
        int index = total -k;
        List<List<Integer>> res = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> layer = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                layer.add(grid[index / n][index % n]);
                index = (index + 1) % total;
            }
            res.add(layer);
        }
        return res;
    }

    public static void main(String[] args) {
        ShiftGrid1260 shiftGrid1260 = new ShiftGrid1260();
        System.out.println(shiftGrid1260.shiftGrid(TransformUtil.toIntMatrix("[[1,2,3],[4,5,6],[7,8,9]]"), 1));
    }
}
