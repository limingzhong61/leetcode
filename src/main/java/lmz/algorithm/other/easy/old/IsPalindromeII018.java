package lmz.algorithm.other.easy.old;

public class IsPalindromeII018 {
    public boolean isPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j; i++,j--){
            while(i < j && !(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))){
                i++;
            }
            while(i < j && !(Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j)))){
                j--;
            }
            if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))){
                return false;
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        IsPalindromeII018 isPalindromeII018 = new IsPalindromeII018();
        System.out.println(isPalindromeII018.isPalindrome("0P"));
    }
}
