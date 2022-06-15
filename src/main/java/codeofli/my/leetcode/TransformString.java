package codeofli.my.leetcode;

import java.util.stream.Stream;

public class TransformString {

    public static String ArrayToJavaForm(String original) {
        return original.replaceAll("\\[", "{").
                replaceAll("\\]", "}").
                replaceAll("\"", "'");
    }

    public static int[] toIntArray(String original) {
        String s = original.replaceAll("\\[", "").
                replaceAll("\\]", "").
                replaceAll(" ", "");
        if ("".equals(s)) {
            return new int[0];
        }
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        return nums;
    }

    /**
     * @param original 输入格式：[[5,3],[4,0],[2,1]]
     * @return
     */
    public static int[][] toIntMatrix(String original) {
        if ("".equals(original)) {
            return new int[0][0];
        }
        //先统一为：[5,3],[4,0],[2,1],
        String[] split = (original.substring(1, original.length() - 1) + ",").split("],");

        int[][] matrix = new int[split.length][];
        int index = 0;
        for (String s : split) {
            matrix[index++] = toIntArray(s.substring(1));
        }
        return matrix;
    }

    /**
     * @param matrix ： 二维数组
     * @return 输出格式：[[5,3],[4,0],[2,1]]
     */
    public static String matrixToStr(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(',');
            }
            sb.deleteCharAt(sb.length() - 1).append("],");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ArrayToJavaForm("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"));
    }
}
