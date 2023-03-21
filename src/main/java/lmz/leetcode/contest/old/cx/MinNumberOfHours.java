package lmz.leetcode.contest.old.cx;

import lmz.my.leetcode.TransformUtil;

public class MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int startEnergy = 1;
        for (int i : energy) {
            startEnergy += i;
        }
        //1 <= n <= 100
        int needE = startEnergy - initialEnergy;
        int n = experience.length;
        int sum = 0;
        int maxNeed = experience[0] + 1;
        for (int i = 0; i < n; i++) {
            maxNeed = Math.max(experience[i] - sum + 1,maxNeed);
            sum += experience[i];
        }
        int needExp = maxNeed - initialExperience;
        needExp = Math.max(needExp, 0);
        needE = Math.max(needE, 0);
        return needExp + needE;
    }

    public static void main(String[] args) {
        MinNumberOfHours minNumberOfHours = new MinNumberOfHours();
        //int m = Arrays.stream(TransformUtil.toIntArray("[58,47,100,71,47,6,92,82,35,16,50,15,42,5,2,45,22]\n")).sum();
        //System.out.println(m);
        testCase(minNumberOfHours, 94, 70, "[58,47,100,71,47,6,92,82,35,16,50,15,42,5,2,45,22]\n", "[77,83,99,76,75,66,58,84,44,98,70,41,48,7,10,61,28]", 650);
        testCase(minNumberOfHours, 4, 39, "[70,22,27,60,55,29,41,7,90,60,25,34,60,52,46]", "[28,96,64,75,83,9,61,31,16,48,33,82,98,81,23]", 705);
    }

    private static void testCase(MinNumberOfHours minNumberOfHours, int initialEnergy, int initialExperience, String original, String original1, int x) {
        System.out.println(minNumberOfHours.minNumberOfHours(initialEnergy, initialExperience,
                TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1)));
        System.out.println(minNumberOfHours.minNumberOfHours(initialEnergy, initialExperience,
                TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1)) == x);
    }
}
