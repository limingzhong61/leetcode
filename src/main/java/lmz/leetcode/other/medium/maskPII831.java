//package lmz.leetcode.other.medium;
//
///**
// * @author: limingzhong
// * @create: 2023-04-01 9:31
// */
//public class MaskPII831 {
//    public String maskPII(String s) {
//        int n = s.length();
//        char[] cs = s.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        if (Character.isDigit(cs[0])) {
//            int cnt = 0;
//            for (int i = 0; i < n; i++) {
//                if (Character.isDigit(cs[i])) {
//                    cnt++;
//                }
//            }
//            cnt -= 10;
//            int i  = 0;
//            if (cnt > 0) {
//                sb.append('+');
//
//                for(; i < n && cnt > 0; i++){
//                    if (Character.isDigit(cs[i])) {
//                        sb.append(cs[i]);
//                        cnt--;
//                    }
//                }
//            }
//            int x = 0;
//            for (; i < n; i++) {
//                if (Character.isDigit(cs[i])) {
//                    if(cnt > 0){
//                        sb.append(cs[i]);
//                    }else if (cnt == 0) {
//                        sb.append('-');
//                    }else{
//
//                    }
//                    cnt--;
//                }
//            }
//        } else { // email
//            sb.append(Character.toLowerCase(cs[0]));
//            System.out.println(Character.toLowerCase(cs[0]));
//            for (int i = 0; i < 5; i++)
//                sb.append('*');
//            int idx = s.indexOf('@');
//            if(idx < 0){
//                System.out.println(s);
//                return "";
//            }
//            sb.append(Character.toLowerCase(cs[idx-1]));
//            sb.append('@');
//            for(int i = idx+1; i < n; i++){
//                sb.append(Character.toLowerCase(cs[i]));
//            }
//        }
//        return sb.toString();
//    }
//}
