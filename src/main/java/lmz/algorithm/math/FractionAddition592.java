package lmz.algorithm.math;

/**
 * 分数加减运算
 */
public class FractionAddition592 {
    /**
     * @param expression format: expression = "-1/2+1/2+1/3"
     * @return
     */
    int i =0;
    char[] chars;
    public String fractionAddition(String expression) {
        i = 0;
        char[] chars = expression.toCharArray();
        this.chars = chars;
        long preSon = 0,preParent = 0;
        long nextSon = 0, nextParent = 0;
        long sign = 1;
        if(chars[i] == '-'){
            i++;
            sign = -1;
        }
        preSon = getNextNum()*sign;
        i++; // '/'
        preParent = getNextNum();
        boolean add = true;
        for (; i < chars.length;) {
            if (chars[i] == '-') {
                add = false;
            } else if (chars[i] == '+') {
                add = true;
            }
            i++; // '-' | '+'
            nextSon = getNextNum();
            i++; // '/'
            nextParent = getNextNum();
            long parentGcd = gcd(nextParent, preParent);
            long nextF = preParent / parentGcd;
            long preF = nextParent / parentGcd;
            // 累计计算的pre上
            preParent *= preF;
            if(add){
                preSon = preSon * preF + nextSon * nextF;
            }else{
                preSon = preSon * preF - nextSon * nextF;
            }
            if(preSon != 0){
                long gcd = gcd(preParent, Math.abs(preSon));
                preParent /= gcd;
                preSon /= gcd;
            }else{
                preParent = 1; // "0/1"
            }
        }
        return preSon + "/" + preParent;
    }
    long getNextNum(){
        long digit = 0;
        for(;i < chars.length &&  Character.isDigit(chars[i]);i++){
            digit = digit * 10 + (chars[i] - '0');
        }
        return digit;
    }

    public static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public long gcd2(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }


    public static void main(String[] args) {
        FractionAddition592 fractionAddition592 = new FractionAddition592();
        testCase(fractionAddition592, "-1/2+1/2", "0/1");
        testCase(fractionAddition592, "-1/2+1/2+1/3", "1/3");
        testCase(fractionAddition592, "1/3-1/2", "-1/6");
    }

    private static void testCase(FractionAddition592 fractionAddition592, String expression, String anObject) {

        System.out.println(fractionAddition592.fractionAddition(expression));
        System.out.println(fractionAddition592.fractionAddition(expression).equals(anObject));
    }
}
