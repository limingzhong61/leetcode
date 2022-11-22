package codeofli.leetcode.other.everyday.slide_window;

import codeofli.my.leetcode.TransformUtil;


public class MovingAverageII41 {

    static class MovingAverage {
        int sum = 0;
        int size;
        int elementSize = 0;
        int[] sideWindow;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            sideWindow = new int[size];
        }

        public double next(int val) {
            sum = sum + val - sideWindow[elementSize % size];
            sideWindow[elementSize % size] = val;
            elementSize++;
            return (double) sum/ (Math.min(elementSize, size));
        }
    }

    public static void main(String[] args) {
        int[] array = TransformUtil.toIntArray(" [[3], [1], [10], [3], [5]]");
        MovingAverage movingAverage = new MovingAverage(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.println("" + movingAverage.next(array[i]));
        }
    }

}
