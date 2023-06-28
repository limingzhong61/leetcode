package lmz.algorithm.contest.old.c_315;

public class SumOfNumberAndReverse {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = 0; i <= num; i++){
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);
            String reverseStr = sb.reverse().toString();
            int reverse = Integer.parseInt(reverseStr);
            if(i + reverse == num){
                //System.out.println(i);
                //System.out.println(reverse);
                return true;
            }
        }
        return false;
    }
}
