package lmz.algorithm.math.string_calculate;

public class AddBinary67 {
    /**
     * 字符串加法，只不过遇到2就进位
     */
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 2;
            res.append(sum % 2);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary67 addBinary67 = new AddBinary67();
        testCase(addBinary67, "1010", "1011", "10101");
        testCase(addBinary67, "1111", "1111", "11110");
    }

    private static void testCase(AddBinary67 addBinary67, String a, String a1, String anObject) {
        System.out.println(addBinary67.addBinary(a, a1));
        System.out.println(addBinary67.addBinary(a, a1).equals(anObject));
    }
}
