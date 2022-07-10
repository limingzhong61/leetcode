package codeofli.leetcode.contest.c301;

import java.util.Locale;

public class CanChange6114 {
    public boolean canChange(String start, String target) {
        char[] startChars = start.toCharArray();
        char[] targetChars = target.toCharArray();
        //n == start.length == target.length
        int n = startChars.length;
        for (int i = 0; i < n; ) {
            if (startChars[i] != targetChars[i]) {
                if (startChars[i] == '_') {
                    if (targetChars[i] == 'L') {
                        for (int j = i + 1; j < n; j++) {
                            if (startChars[j] == 'L') {
                                swap(startChars, i, j);
                                if (startChars[i] == targetChars[i]) {
                                    break;
                                }
                            }
                        }
                        if (startChars[i] != targetChars[i]) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (startChars[i] == 'R') { //
                    if (targetChars[i] == '_') {

                        if (i + 1 < n && startChars[i + 1] == '_') { // "R_"
                            swap(startChars, i, i + 1);
                        } else if(i + 1 < n && startChars[i + 1] == 'R') { // "RR_","RRR...__"
                            int j = i+1;
                            //find next '_'
                            for(; j < n; j++){
                                if(startChars[j] == 'R'){ //"RRR...__"
                                    continue;
                                }else if(startChars[j] == '_'){
                                    break;
                                }else { // 'L'
                                    return false;
                                }
                            }
                            swap(startChars,i,j);
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }

            i++;
        }
        return true;
    }

    private void swap(char[] startChars, int i, int j) {
        char temp = startChars[i];
        startChars[i] = startChars[j];
        startChars[j] = temp;
    }

    public static void main(String[] args) {
        CanChange6114 canChange6114 = new CanChange6114();
        testCase(canChange6114, "_L__R__R_", "L______RR", true);
        testCase(canChange6114, "R_L_", "__LR", false);
        testCase(canChange6114, "_R", "R_", false);
        testCase(canChange6114, "RRRR_", "_RRRR", true);
        testCase(canChange6114, "_", "L", false);
        testCase(canChange6114, "___LLL", "LLL___", true);
        testCase(canChange6114, "R___L_RR_R_______L_____R__________RLL__",
                "___RLR_R_RLR____L___LL___R_L____LRLRL__", false);
    }

    private static void testCase(CanChange6114 canChange6114, String l__r__r_, String l______rr, boolean b) {
        System.out.println(canChange6114.canChange(l__r__r_, l______rr));
        System.out.println(String.valueOf(canChange6114.canChange(l__r__r_, l______rr) == b).toUpperCase(Locale.ROOT));
    }
}
