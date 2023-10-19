package com.lmz.leetcode.practice.other.old.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCalendarTwo731 {
    /**
     * 两个list：
     * 一个记录一重预定
     * 一个记录两重预定
     */
    static class MyCalendarTwo {
        List<int[]> oneList = new ArrayList<>();
        List<int[]> twoList = new ArrayList<>();

        public MyCalendarTwo() {
        }

        public boolean book(int start, int end) {
            for (int[] range : twoList) {
                if (start < range[1] && end > range[0]) { //交集？
                    return false;
                }
            }
            for (int[] range : oneList) {
                if (start < range[1] && end > range[0]) { //交集？
                    //start...[0]...[1]...end || start...[0]...end...[1]  || || [0]...start...end...[1] ||  [0]...start...[1]...end
                    twoList.add(new int[]{Math.max(start, range[0]), Math.min(end, range[1])});
                }
            }
            oneList.add(new int[]{start, end});
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        testCase(myCalendarTwo, "[[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]", "[null,true,true,true,false,true,true]");
        testCase(myCalendarTwo, "[[],[24,40],[43,50],[27,43],[5,21],[30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]",
                "[null,true,true,true,true,false,false,true,false,false,false]");
        testCase(myCalendarTwo, "[[],[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17]," +
                        "[24,33],[23,28],[21,27],[47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,50],[33,39],[30,36]," +
                        "[6,15],[21,27],[49,50],[38,45],[4,12],[46,50],[13,21]]",
                "[null,true,true,true,true,true,true,true,true,false,false,false,false,false,true,false,false,false" +
                        ",true,false,false,false,false,false,false,false,false,true,false,false,false]");

    }

    private static void testCase(MyCalendarTwo myCalendarTwo, String text1, String text2) {
        myCalendarTwo.twoList.clear();
        myCalendarTwo.oneList.clear();
        String rule1 = "\\d+,\\s*\\d+";
        Pattern p1 = Pattern.compile(rule1);
        Matcher m1 = p1.matcher(text1);
        String rule2 = "true|false";
        Pattern p2 = Pattern.compile(rule2);
        Matcher m2 = p2.matcher(text2);
        while (m1.find()) {
            String group = m1.group(0);
            String group2 = null;
            if (m2.find()) {
                group2 = m2.group(0);
            }
            String[] split = group.split(",");
            System.out.println("匹配结果：" + m1.group(0) + "," + group2);
            boolean book = myCalendarTwo.book(Integer.parseInt(split[0]), Integer.parseInt(split[1].trim()));
            System.out.println(book);

            System.out.println(String.valueOf(book ==
                    Boolean.parseBoolean(group2)).toUpperCase(Locale.ROOT));
            if (book != Boolean.parseBoolean(group2)) {
                System.out.println("error---------------------------------------------------------------------");
            }
        }
    }

}
