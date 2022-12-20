package lmz.leetcode.graph_parse_ds.search_and_recur;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount13 {
    public static int getNumberDigitSum(int num) {
        int sum = 0;
        //获取每一位的数字
        //获取数字位数，用do-while,防止0的情况
        do {
            sum += num % 10;
            num /= 10;
        } while (num != 0);
        return sum;
    }

    /**
     * leetcode:bfs+优化
     * 可达性分析，机器人只需要向右、向下移动即可
     */
    public int movingCount(int m, int n, int k) {
        if (m == 0 && n == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        //移动数组
        int[][] next = new int[][]{
                {0, 1}, {1, 0}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int count = 1;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for (int[] ints : next) {
                int nextI = pos[0] + ints[0];
                int nextJ = pos[1] + ints[1];
                int digitSum = getNumberDigitSum(nextI) + getNumberDigitSum(nextJ);
                if (digitSum <= k && nextI >= 0 && nextI < m &&
                        nextJ >= 0 && nextJ < n && !visited[nextI][nextJ]) {
                    count++;
                    visited[nextI][nextJ] = true;
                    queue.add(new int[]{nextI, nextJ});
                }
            }
        }
        return count;
    }


    /**
     * leetcode:优化
     * 可达性分析，机器人只需要向下移动即可
     */
    public int movingCount2(int m, int n, int k) {
        if (m == 0 && n == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        return counting2(0, 0, k, visited);
    }

    private int counting2(int i, int j, int k, boolean[][] visited) {
        int digitSum = getNumberDigitSum(i) + getNumberDigitSum(j);
        if (digitSum > k || i < 0 || i >= visited.length ||
                j < 0 || j >= visited[0].length || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        //移动数组
        int next[][] = new int[][]{
                {0, 1}, {1, 0}
        };
        int count = 0;
        for (int a = 0; a < next.length; a++) {
            int nextI = i + next[a][0];
            int nextJ = j + next[a][1];
            count += counting2(nextI, nextJ, k, visited);
        }
        return count + 1;
    }


    /**
     * 一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     */
    public int movingCount1(int m, int n, int k) {
        if (m == 0 && n == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        return counting1(0, 0, k, visited);
    }

    private int counting1(int i, int j, int k, boolean[][] visited) {
        int digitSum = getNumberDigitSum(i) + getNumberDigitSum(j);
        if (digitSum > k || i < 0 || i >= visited.length ||
                j < 0 || j >= visited[0].length || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        //移动数组
        int next[][] = new int[][]{
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        int count = 0;
        for (int a = 0; a < next.length; a++) {
            int nextI = i + next[a][0];
            int nextJ = j + next[a][1];
            count += counting1(nextI, nextJ, k, visited);
        }
        return count + 1;
    }

    public static void main(String[] args) {
        MovingCount13 movingCount13 = new MovingCount13();
        System.out.println(movingCount13.movingCount(2, 3, 1));
        System.out.println(movingCount13.movingCount(2, 3, 1) == 3);
        System.out.println(movingCount13.movingCount(3, 1, 0));
        System.out.println(movingCount13.movingCount(3, 1, 0) == 1);
        System.out.println(movingCount13.movingCount(0, 0, 0));
        System.out.println(movingCount13.movingCount(0, 0, 0) == 1);
        System.out.println(movingCount13.movingCount(100, 100, 20));
        System.out.println(movingCount13.movingCount(100, 100, 20) == 6117);
    }
}
