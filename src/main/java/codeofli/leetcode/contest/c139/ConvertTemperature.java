package codeofli.leetcode.contest.c139;

public class ConvertTemperature {
    public double[] convertTemperature(double celsius) {
        var res = new double[2];
        res[0] = celsius + 273.15;
        res[1] = celsius *1.80 + 32.00;
        return res;
    }
}
