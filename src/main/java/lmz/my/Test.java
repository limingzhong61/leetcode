package lmz.my;

public class Test {

    public static void main(String[] args) {
        String s = "             [1,0,0,0,0,0,1";
        System.out.println(s);
        System.out.println(s.replace("\\s+",""));
        System.out.println(TestEnum.TEST_A.getClass());

    }
}
