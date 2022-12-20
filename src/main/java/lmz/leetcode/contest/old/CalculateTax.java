package lmz.leetcode.contest.old;

import lmz.my.leetcode.TransformUtil;

public class CalculateTax {
    public double calculateTax(int[][] brackets, int income) {
        int n = brackets.length;
        double sum = 0;
        for(int i = 0; i < n; i++){
            if(income > brackets[i][0]){
                if(i == 0){
                    sum += (double)1.0* brackets[i][0] * brackets[i][1]/100;
                }else{
                    sum += (double)1.0* (brackets[i][0] - brackets[i-1][0]) * brackets[i][1]/100;
                }
            }else {
                if(i == 0){
                    sum += (double)income * brackets[i][1]/100;
                }else{
                    sum += (double) (income - brackets[i-1][0]) * brackets[i][1]/100;
                }
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        CalculateTax calculateTax = new CalculateTax();
        calculateTax.calculateTax(TransformUtil.toIntMatrix("[[3,50],[7,10],[12,25]]"), 10);
    }

}
