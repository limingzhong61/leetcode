package com.lmz.my;

public class IntegerUtil {

    public int reverseIntegerNotOutRange(int x) {
        //Integer val = x;
        //val.toString();
        int result = 0;
        int symbol = 1;
        if (x < 0) {
            symbol = -1;
            x = -x;
        }
        while (x != 0) {
            int temp = x % 10;
            result = result * 10 + temp;
            x /= 10;
        }
        return result * symbol;
    }

    /**
     *  可以处理翻转后超出int范围的问题
     * @param x
     * @return
     */
    public int reverse(int x) {
        //Integer val = x;
        //val.toString();
        StringBuilder sb =new StringBuilder();
        int symbol = 1;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            sb.append("-");
            x = -x;
        }
        while (x != 0) {
            int temp = x % 10;
            sb.append(temp);
            x /= 10;
        }
        String intMin = String.valueOf(Integer.MIN_VALUE);
        String intMax = String.valueOf(Integer.MAX_VALUE);
        // out range check
        String result = sb.toString();
        if(isNegative && intMin.length() == result.length() && intMin.compareTo(result) < 0){
            return 0;
        }
        if(!isNegative && intMax.length() == result.length() && intMax.compareTo(result) < 0){
            return 0;
        }
        return Integer.parseInt(result);
    }
}
