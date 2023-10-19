package com.lmz.leetcode.practice.other.easy.old;

public class ReformatNumber1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int numberCnt = 0;
        for (char c : number.toCharArray()) {
            if (c != ' ' && c != '-') {
                sb.append(c);
                numberCnt++;
                if (numberCnt % 3 == 0) {
                    sb.append('-');
                }
            }
        }
        if(sb.charAt(sb.length()-1) == '-'){
            sb.deleteCharAt(sb.length()-1);
        }else{
            int i = sb.lastIndexOf("-");
            if (i == sb.length() - 2) {
                String substring = sb.substring(sb.length() - 3);
                // System.out.println(substring);
                sb.delete(sb.length() - 3, sb.length());
                sb.append('-');
                sb.append(substring.charAt(0)).append(substring.charAt(2));
            }
        }

        return  sb.toString();
    }
}
