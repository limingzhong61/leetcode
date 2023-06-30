package lmz.algorithm.other.old.easy;

/**
 * @author: limingzhong
 * @create: 2023-04-17 11:38
 */
public class CountDaysTogether2409 {
    class Solution {
        int[] daysOfMonth = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

            for (int i = 1; i < daysOfMonth.length; i++) {
                daysOfMonth[i] += daysOfMonth[i - 1];
            }

            int a1 = getDayIdx(arriveAlice);
            int a2 = getDayIdx(leaveAlice);
            int b1 = getDayIdx(arriveBob);
            int b2 = getDayIdx(leaveBob);
            // System.out.println(a2);
            // System.out.println(b1);
            if(a1 <= b2 && b1 <= a2){
                return   Math.min(a2,b2)- Math.max(a1,b1) + 1;
            }
            return 0;
        }

        private int getDayIdx(String arriveAlice) {
            String[] split = arriveAlice.split("-");
            return daysOfMonth[Integer.parseInt(split[0]) - 1] + Integer.parseInt(split[1]);
        }
    }
}
