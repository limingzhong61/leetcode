package lmz.leetcode.bruce_solution.bruce_search.my.solution_template.math;

public class FloatEquals {

    public static boolean equals(double a, double b) {
        float diff = 1e-6F;
        return Math.abs(a - b) < diff;
    }
}
