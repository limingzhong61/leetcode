package codeofli.leetcode.simulation;

import java.util.*;

public class MakeLargestSpecial761 {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) return s;
        List<String> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0, loc = 0, score = 0; i < cs.length; i++) {
            score += cs[i] == '1' ? 1 : -1;
            if (score == 0) {
                list.add("1" + makeLargestSpecial(s.substring(loc + 1, i)) + "0");
                loc = i + 1;
            }
        }
        Collections.sort(list, (a, b)->(b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String str : list) sb.append(str);
        return sb.toString();
    }
    /**
     * 暴力搜索：超时
     */
    public String makeLargestSpecial1(String s) {
        return recur(s, 0, s.length() - 1);
    }
    Map<String,String>  record = new HashMap<>();

    private String recur(String s, int left, int right) {
        if(record.containsKey(s)){
            return record.get(s);
        }
        int cnt1 = 0, cnt0 = 0;
        String max = s;
        for (int i = left; i <= right; i++) {
            cnt0 = 0; //重置记数
            cnt1 = 0;
            for (int j = i; j <= right; j++) {  // 判断[i,j]是不是符合条件的二进制序列
                if (s.charAt(j) == '1') {
                    cnt1++;
                } else {
                    cnt0++;
                    if (cnt0 > cnt1) {
                        break;
                    }
                }
                if (cnt0 == cnt1) { //[i,j]符合条件
                    cnt0 = 0;
                    cnt1 = 0;
                    boolean hasK = false;
                    int k;
                    for ( k = j + 1; k <= right; k++) { // [j+1,k]
                        if (s.charAt(k) == '1') {
                            cnt1++;
                        } else {
                            cnt0++;
                            if (cnt0 > cnt1) {
                                break;
                            }
                        }
                        if(cnt0 == cnt1){ //得到 [i,j][j+1,k]
                            hasK = true;

                            String r1 = s.substring(i, j + 1);
                            String r2 = s.substring(j + 1, k + 1);
                            String s1 = r1 + r2;
                            String s2 = r2 + r1;
                            if(s1.compareTo(s2) < 0){ //交换后变大
                                String replace = s.replace(s1, s2);
                                String recur = recur(replace, 0, replace.length() - 1);
                                if(max.compareTo(recur) < 0){
                                    max = recur;
                                }
                            }
                        }
                    }
                    if(!hasK){
                        break;
                    }
                }
            }
        }
        record.put(s,max);
        return max;
    }

    public static void main(String[] args) {
        MakeLargestSpecial761 makeLargestSpecial761 = new MakeLargestSpecial761();
        testCase(makeLargestSpecial761, "11011000", "11100100");
        testCase(makeLargestSpecial761, "111011101001000010", "111110100100100010");
        //testCase(makeLargestSpecial761, "10111001001011001010", "111110100100100010");
    }

    private static void testCase(MakeLargestSpecial761 makeLargestSpecial761, String s, String anObject) {
        System.out.println(makeLargestSpecial761.makeLargestSpecial(s));
        System.out.println(makeLargestSpecial761.makeLargestSpecial(s).equals(anObject));
    }

}
