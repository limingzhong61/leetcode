package codeofli.my.leetcode;

public class TransformString {

    public  static String ArrayToJavaForm(String original){
        return original.replaceAll("\\[", "{").
                replaceAll("\\]","}").
                replaceAll("\"","'");
    }

    public static void main(String[] args) {
        System.out.println(ArrayToJavaForm("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"));
    }
}
