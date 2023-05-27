package lmz.algorithm.data_structure.array_and_strings.two_dem;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes0108 {
    /**
     * leetcode
     * 方法二：使用一个标记变量
     * 关键在于，用原来的第一行和第一列来记录该行和该列是否有0值。
     * 而一个标量，记录第一列是否应该置为0，用第一列的第一个元素标记第一行是否为0.
     * (因为后面使用第一列记录，会破坏掉原有的0值记录，故需要最先记录第一列是否有0值
     * 其次，用[用第一列的第一个元素标记第一行是否为0.],所以需要从后往前置0)
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //数组记录;
        boolean col0 = false;
        for (int i = 0; i < n; i++) {
            //记录0列是否有0值
            if (matrix[i][0] == 0) {
                col0 = true;
            }
            //
            /**
             * i 0->m
             * j 1->m ,即除了第0列，其余都统计归属到原来的第一行和第一列来记录该行和该列是否有0值。
             */
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = n-1; i >= 0; i--){
            //j从1开始，0列为标记
            for(int j = 1; j < m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col0){
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * leetcode
     * 方法二：使用两个标记变量
     * 关键在于，用原来的第一行和第一列来记录该行和该列是否有0值。
     * 而两个标量，记录第一行，第一列是否应该置为0
     * (因为后面使用第一行，第一列记录，会破坏掉原有的0值记录，故需要最先记录第一行、列是否有0值)
     */
    public void setZeroes3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //数组记录;
        boolean row0 = false;
        boolean col0 = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                row0 = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                col0 = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if (row0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * leetcode
     */
    public void setZeroes2(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        //数组记录
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * my:set记录需要置为0的行和列，
     * 第二遍置为0.
     * 注意 matrix:n*m
     */
    public void setZeroes1(int[][] matrix) {
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    colSet.add(j);
                    rowSet.add(i);
                }
            }
        }
        for (Integer j : colSet) {
            for (int i = 0; i < n; i++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer i : rowSet) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes0108 setZeroes0108 = new SetZeroes0108();
        setZeroes0108.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }
}
