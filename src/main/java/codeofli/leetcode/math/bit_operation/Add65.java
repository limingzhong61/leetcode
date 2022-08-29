package codeofli.leetcode.math.bit_operation;

public class Add65 {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }


    public static void main(String[] args) {
        Add65 add65 = new Add65();


        System.out.println(add65.add(3, 7));
        System.out.println(add65.add(3, 7) == 10);

        System.out.println(add65.add(3, -8));
        System.out.println(add65.add(3, -8) == -5);

        System.out.println(add65.add(1, 1));
        System.out.println(add65.add(1, 1) == 2);

        System.out.println(add65.add(5, 4));
        System.out.println(add65.add(5, 4) == 9);

        System.out.println(add65.add(10, 4));
        System.out.println(add65.add(10, 4) == 14);
    }
}
