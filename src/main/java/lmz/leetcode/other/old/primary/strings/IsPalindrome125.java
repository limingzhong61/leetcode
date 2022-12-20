package lmz.leetcode.other.old.primary.strings;

public class IsPalindrome125 {
    /**
     * 边处理边判断
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0,j = chars.length-1; i < j; i++,j--){
            while (i<j && !Character.isLetterOrDigit(chars[i])){
                i++;
            }
            while (i<j && !Character.isLetterOrDigit(chars[j])){
                j--;
            }
            if (chars[i] != chars[j]) {
                //忽略字母的大小写比较
                // 比较失败可能是大小写不一致
                chars[i] = Character.toLowerCase(chars[i]);
                chars[j] = Character.toLowerCase(chars[j]);
                if(chars[i] == chars[j]){
                    continue;
                }
                return false;
            }
        }
        return  true;
    }
    /**
     * my
     */
    public boolean isPalindrome1(String s) {
        //正则替换
        char[] chars = s.replaceAll("\\W+", "").toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                // 比较失败可能是大小写不一致
                chars[i] = Character.toLowerCase(chars[i]);
                chars[j] = Character.toLowerCase(chars[j]);
                if(chars[i] == chars[j]){
                    continue;
                }
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        IsPalindrome125 isPalindrome125 = new IsPalindrome125();
        System.out.println(isPalindrome125.isPalindrome(".,"));
    }

}
