package codeofli.leetcode.everyday.judge;

import codeofli.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.Locale;

public class ValidSquare593 {
    /**
     *p1与p2,p3,p4组成对角3种情况
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2)) {
            return false;
        }
        if (help(p1, p2, p3, p4)) {
            return true;
        }
        if (Arrays.equals(p1, p3)) {
            return false;
        }
        if (help(p1, p3, p2, p4)) {
            return true;
        }
        if (Arrays.equals(p1, p4)) {
            return false;
        }
        if (help(p1, p4, p2, p3)) {
            return true;
        }
        return false;
    }

    /**
     * 两组对角点分别是(p1,p2)(p3,p4)
     */
    public boolean help(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] v1 = {p1[0] - p2[0], p1[1] - p2[1]};
        int[] v2 = {p3[0] - p4[0], p3[1] - p4[1]};
        if (checkMidPoint(p1, p2, p3, p4) && checkLength(v1, v2) && calCos(v1, v2)) {
            return true;
        }
        return false;
    }

    public boolean checkLength(int[] v1, int[] v2) {
        return (v1[0] * v1[0] + v1[1] * v1[1]) == (v2[0] * v2[0] + v2[1] * v2[1]);
    }

    public boolean checkMidPoint(int[] p1, int[] p2, int[] p3, int[] p4) {
        return (p1[0] + p2[0]) == (p3[0] + p4[0]) && (p1[1] + p2[1]) == (p3[1] + p4[1]);
    }

    /**
     * v1[0]/v1[1] * v2[0]/v2[1] = -1;
     * v1[0] * v2[0] = -v1[1] * v2[1]
     */
    public boolean calCos(int[] v1, int[] v2) {
        return (v1[0] * v2[0] + v1[1] * v2[1]) == 0;
    }

    /**
     * 求出6条边，四条边长和两条对角线。(4个点6条边)
     * **边长相等的只有正方形和菱形，对角线又相等的只有正方形**
     * 所以排序判断边长以及对角线是否相等即可
     * 注意：有重合点len=0
     * -104 <= xi, yi <= 104
     */
    public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
        //记录边长的平方
        int[] len = new int[6];
        int n = 4;
        int[][] ps = new int[n][2];
        int index = 0;
        ps[index++] = p1;
        ps[index++] = p2;
        ps[index++] = p3;
        ps[index] = p4;
        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                len[index] = (ps[i][0] - ps[j][0]) * (ps[i][0] - ps[j][0]) + (ps[i][1] - ps[j][1]) * (ps[i][1] - ps[j][1]);
                if (len[index] == 0) {//重合点
                    return false;
                }
                index++;
            }
        }
        Arrays.sort(len);
        return len[0] == len[1] && len[1] == len[2] && len[2] == len[3] && len[4] == len[5];
    }

    /**
     * error /.////////////error error
     * 如果为正方形四个点
     * x1，y1---->两个点，（x2,y2)(x3,y3)且x1 == x2 &&y1 == y3 && 边长相等||
     * 第4个点则，应该为第三第四个点的另外两个点
     */
    public boolean validSquare111(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x1 = p1[0], y1 = p1[1];
        int x2, y2;
        //<p_i,x_i>
        int[][] ps = new int[5][2];
        int index = 1;
        ps[index++] = p1;
        ps[index++] = p2;
        ps[index++] = p3;
        ps[index] = p4;
        boolean find = false;
        for (int i = 2; i <= 4; i++) {
            if (ps[i][0] == x1) {
                swap(ps, i, 2);
                find = true;
                break;
            }
        }
        if (!find) {
            return false;
        }
        int len1 = Math.abs(ps[2][1] - ps[1][1]);
        int y4 = ps[2][1];
        find = false;
        for (int i = 3; i <= 4; i++) {
            if (ps[i][1] == y1) {
                swap(ps, i, 3);
                find = true;
                break;
            }
        }
        if (!find) {
            return false;
        }
        //找到了3个点
        int len2 = Math.abs(ps[3][0] - ps[1][0]);
        int x4 = ps[3][0];
        return len1 == len2 && x4 == ps[4][0] && y4 == ps[4][1];
    }

    private void swap(int[][] ps, int a, int b) {
        int[] temp = ps[a];
        ps[a] = ps[b];
        ps[b] = temp;
    }

    public static void main(String[] args) {
        ValidSquare593 validSquare593 = new ValidSquare593();
        testCase(validSquare593, "[0,0]", "[1,1]", "[1,0]", "[0,1]", true);
        testCase(validSquare593, "[0,0]", "[1,1]", "[1,0]", "[0,12]", false);
        testCase(validSquare593, "[1,0]", "[-1,0]", "[0,1]", "[0,-1]", true);
        testCase(validSquare593, "[0,0]", "[0,0]", "[0,0]", "[0,0]", false);
    }

    private static void testCase(ValidSquare593 validSquare593, String p1, String p2, String p3, String p4, boolean x) {
        System.out.println(validSquare593.validSquare(
                TransformUtil.toIntArray(p1),
                TransformUtil.toIntArray(p2),
                TransformUtil.toIntArray(p3),
                TransformUtil.toIntArray(p4)));
        System.out.println(String.valueOf(validSquare593.validSquare(
                TransformUtil.toIntArray(p1),
                TransformUtil.toIntArray(p2),
                TransformUtil.toIntArray(p3),
                TransformUtil.toIntArray(p4)) == x).toUpperCase(Locale.ROOT));
    }

}
