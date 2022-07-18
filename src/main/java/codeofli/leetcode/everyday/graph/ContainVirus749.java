package codeofli.leetcode.everyday.graph;

import codeofli.leetcode.contest.c302.SmallestTrimmedNumbers6121;
import codeofli.my.leetcode.TransformUtil;
import codeofli.my.util.matrix.MatrixUtil;

import java.util.*;

public class ContainVirus749 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * leetcode:
     */
    public int containVirus1(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;
        while (true) {
            List<Set<Integer>> neighbors = new ArrayList<>();
            List<Integer> firewalls = new ArrayList<>();
            //获取一次fireWall，和需要的感染数neighbors
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1) {
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[]{i, j});
                        Set<Integer> neighbor = new HashSet<>();
                        int firewall = 0, idx = neighbors.size() + 1;
                        isInfected[i][j] = -idx;

                        while (!queue.isEmpty()) {
                            int[] arr = queue.poll();
                            int x = arr[0], y = arr[1];
                            for (int d = 0; d < 4; ++d) {
                                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 1) {
                                        queue.offer(new int[]{nx, ny});
                                        isInfected[nx][ny] = -idx;
                                    } else if (isInfected[nx][ny] == 0) {
                                        ++firewall; //边界，与0相连，该区域设置防火墙，无需考虑重复情况
                                        neighbor.add(getHash(nx, ny)); // 需要判重
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        firewalls.add(firewall);
                    }
                }
            }

            if (neighbors.isEmpty()) {
                break;
            }

            int idx = 0;
            for (int i = 1; i < neighbors.size(); ++i) {
                if (neighbors.get(i).size() > neighbors.get(idx).size()) {
                    idx = i;
                }
            }
            ans += firewalls.get(idx);
            boolean printBegin = false;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] != -idx - 1) {
                            isInfected[i][j] = 1;
                        } else {
                            if (!printBegin) {
                                printBegin = true;
                                System.out.println(i + "," + j);
                            }
                            isInfected[i][j] = 2;
                        }
                    }
                }
            }
            for (int i = 0; i < neighbors.size(); ++i) {
                if (i != idx) {
                    for (int val : neighbors.get(i)) {
                        int x = val >> 16, y = val & ((1 << 16) - 1);
                        isInfected[x][y] = 1;
                    }
                }
            }
            if (neighbors.size() == 1) {
                break;
            }
        }
        return ans;
    }

    public int getHash(int x, int y) {
        return (x << 16) ^ y;
    }

    /**
     * 直接模拟，3次BFS
     * 在整个描述的过程中，总有一个相邻的病毒区域，它将在下一轮 严格地感染更多未受污染的方块
     * 1 <= m, n <= 50
     */
    int inWall = -1;

    public int containVirus(int[][] isInfected) {

        int m = isInfected.length, n = isInfected[0].length;
        //因为会有重叠的感染区域，故用一个新的数组标记感染区域
        boolean[][] willInfect = new boolean[m][n];
        int totalWall = 0;
        while (true) {
            // 统计独立的个数和大小
            int markValue = 2; //1已经用过，故用2
            // <markValue,markValue>
            List<int[]> cntList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1) {
                        for (var item : willInfect) { //因为会有重叠的感染区域，故需要每次重置
                            Arrays.fill(item, false);
                        }
                        cntList.add(new int[]{markValue, bfs(isInfected, willInfect, i, j, markValue)});
                        markValue++;
                    }
                }
            }
            if (cntList.size() == 0) { //没有病毒
                return 0;
            }
            Collections.sort(cntList, (nums1, nums2) -> nums2[1] - nums1[1]);

            int maxMarkValue = cntList.get(0)[0];
            boolean getFlag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == maxMarkValue) {
                        totalWall += getWallCnt(isInfected, i, j, maxMarkValue);
                        getFlag = true;
                        break;
                    }
                }
                if (getFlag) {
                    break;
                }
            }
            if (cntList.size() == 1) {
                break;
            }
            // 其他地方（不在墙内的地方）开始感染
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] != inWall && isInfected[i][j] != 0 && isInfected[i][j] != 1) {
                        infecting(isInfected, i, j, isInfected[i][j]);
                    }
                }
            }
        }
        return totalWall;
    }

    private int getWallCnt(int[][] isInfected, int x, int y, int markValue) {

        int wallCnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int m = isInfected.length, n = isInfected[0].length;
        isInfected[x][y] = inWall; //标记在墙内
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            for (int[] item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) { //下标合法
                    if (isInfected[nextX][nextY] == markValue) {
                        isInfected[nextX][nextY] = inWall; //标记在墙内
                        queue.add(new int[]{nextX, nextY});
                    } else if (isInfected[nextX][nextY] == 0) {
                        wallCnt++;
                    }
                }
            }
        }
        return wallCnt;
    }


    //右下左上（顺时针）移动数组
    int[][] next = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public int infecting(int[][] isInfected, int x, int y, int markValue) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int m = isInfected.length, n = isInfected[0].length;
        isInfected[x][y] = 1; //标记访问
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            for (int[] item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) { //下标合法
                    if (isInfected[nextX][nextY] != inWall && isInfected[nextX][nextY] != 1) {
                        if (isInfected[nextX][nextY] == markValue) { //可以继续感染，加入队列
                            queue.add(new int[]{nextX, nextY});
                        } //  isInfected[nextX][nextY] == 0 || == 1
                        isInfected[nextX][nextY] = 1; //标记访问
                    }
                }
            }
        }
        return cnt;
    }

    public int bfs(int[][] isInfected, boolean[][] willInfect, int x, int y, int markValue) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int m = isInfected.length, n = isInfected[0].length;
        isInfected[x][y] = markValue; //标记访问
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            for (int[] item : next) {
                int nextX = x + item[0];
                int nextY = y + item[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) { //下标合法
                    if (isInfected[nextX][nextY] == 1) {
                        isInfected[nextX][nextY] = markValue; //标记访问
                        queue.add(new int[]{nextX, nextY});
                    } else if (isInfected[nextX][nextY] == 0 && !willInfect[nextX][nextY]) { //未被感染为0，用willInfect标记将要被感染的
                        willInfect[nextX][nextY] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ContainVirus749 containVirus749 = new ContainVirus749();
        testCase(containVirus749, "[[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]", 10);
        testCase(containVirus749, "[[1,1,1],[1,0,1],[1,1,1]]", 4);
        testCase(containVirus749, "[[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]", 13);
        testCase(containVirus749, "[[0,1,0,0,0,0,0,1],[0,1,0,1,0,0,0,1],[0,0,0,0,0,0,0,1]]", 16);
        testCase(containVirus749, "[[0]]", 0);
        testCase(containVirus749, "[[0,1,1,1,1,0,1,1,0,0],[0,0,0,0,0,0,1,1,0,0],[0,0,0,0,0,1,0,0,0,1],[0,0,1,0,0,0,0,1,0,0]," +
                        "[1,0,0,0,0,0,1,0,0,0]," +
                        "[0,0,1,1,0,1,0,0,1,0],[0,0,0,0,0,0,0,0,0,1],[0,0,0,0,0,1,1,0,0,0],[0,0,0,1,0,1,0,0,0,0],[0,0,1,0,0,0,0,0,1,0]]",
                57);
        testCase(containVirus749, "[[1,1,0,0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,0,0],[1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0]," +
                        "[1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,1],[1,1,0,1,1,0,1,0,1,1,0,0,0,0,0,1,1,1,0,1]," +
                        "[1,1,1,0,1,1,0,1,1,0,0,1,1,0,1,1,1,0,0,1],[0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,0,1,0,1,0]," +
                        "[1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1],[1,0,0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,0,0]," +
                        "[1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1],[1,0,0,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1]," +
                        "[1,0,1,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1],[1,0,1,1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1]," +
                        "[1,0,1,0,1,0,0,1,0,1,1,1,0,1,0,0,1,1,0,1],[1,1,0,0,0,1,0,0,1,1,1,0,0,0,0,1,0,1,0,1]," +
                        "[0,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0,0,1,0,0],[1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,0,0,0,0]," +
                        "[0,1,0,0,0,1,1,0,0,1,1,1,1,1,1,0,1,0,0,1],[1,1,1,0,1,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1]," +
                        "[0,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,1,1,1],[0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,0,0,0,0]]",
                231);
        //MatrixUtil.printMatrix(TransformUtil.toIntMatrix("[[1,1,0,0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,0,0],[1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0]," +
        //        "[1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,1],[1,1,0,1,1,0,1,0,1,1,0,0,0,0,0,1,1,1,0,1]," +
        //        "[1,1,1,0,1,1,0,1,1,0,0,1,1,0,1,1,1,0,0,1],[0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,0,1,0,1,0]," +
        //        "[1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1],[1,0,0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,0,0]," +
        //        "[1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1],[1,0,0,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1]," +
        //        "[1,0,1,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1],[1,0,1,1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1]," +
        //        "[1,0,1,0,1,0,0,1,0,1,1,1,0,1,0,0,1,1,0,1],[1,1,0,0,0,1,0,0,1,1,1,0,0,0,0,1,0,1,0,1]," +
        //        "[0,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0,0,1,0,0],[1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,0,0,0,0]," +
        //        "[0,1,0,0,0,1,1,0,0,1,1,1,1,1,1,0,1,0,0,1],[1,1,1,0,1,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1]," +
        //        "[0,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,1,1,1],[0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,0,0,0,0]]"));
    }

    private static void testCase(ContainVirus749 containVirus749, String original, int x) {
        System.out.println(containVirus749.containVirus(TransformUtil.toIntMatrix(
                original)));
        System.out.println(containVirus749.containVirus(TransformUtil.toIntMatrix(
                original)) == x);
    }
}
