package codeofli.leetcode.math.string_calculate.expression;


public class SolveEquation640 {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0], right = split[1];
        int[] a = calculate(left);
        int[] b = calculate(right);
        //a[0]x+a[1] = b[0]x+b[1]
        int cntX = a[0] - b[0];
        int number = b[1] - a[1];
        if (cntX == 0) {
            return number == 0 ? "Infinite solutions" : "No solution";
        }
        //equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
        if (number % cntX == 0) { // x需要是整数
            return "x=" + number / cntX;
        }
        return "No solution";
    }

    /**
     * 归结为 [0]x+[1]的形式
     */
    private int[] calculate(String s) {
        int len = s.length();
        int numSum = 0, cntX = 0, sign = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'x') {//x和-x形式
                cntX += sign;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else { // digit
                int num = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (i + 1 < len && s.charAt(i + 1) == 'x') { //2x形式
                    i++; //移动x的一位
                    cntX += num * sign;
                } else {
                    numSum += num * sign;
                }
            }
        }
        return new int[]{cntX, numSum};
    }

    public static void main(String[] args) {
        SolveEquation640 solveEquation640 = new SolveEquation640();
        testCase(solveEquation640, "x+5-3+x=6+x-2", "x=2");
        testCase(solveEquation640, "x=x", "Infinite solutions");
        testCase(solveEquation640, "2x=x", "x=0");
        testCase(solveEquation640, "x=x+1", "No solution");
        testCase(solveEquation640, "x+5-3+x=6+2x-2", "No solution");
        testCase(solveEquation640, "-x=-1", "x=1");
        testCase(solveEquation640, "3x=33+22+11", "x=22");

    }

    private static void testCase(SolveEquation640 solveEquation640, String equation, String Infinite_solutions) {
        System.out.println(solveEquation640.solveEquation(equation));
        System.out.println(solveEquation640.solveEquation(equation).equals(Infinite_solutions));
    }
}
