package codeofli.leetcode.math.date;

public class DayOfYear1154 {
    /**
     * 闰年计算：
     * 1.普通年能被4整除且不能被100整除的为闰年
     * 2.世纪年能被400整除的是闰年。
     */
    int[] monthDays = new int[]{-1,31,28,31,30,31,30,31,31,30,31,30,31};
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        if(year % 400  == 0|| (year % 4 == 0 && year % 100 != 0)){
            monthDays[2] = 29;
        }
        for(int i = 1; i < month; i++){
            day += monthDays[i];
        }
        return  day;
    }
}
