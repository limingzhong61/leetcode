package baidu.t3;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            Set<String> set = new HashSet<>();
            String line1 = in.nextLine();
            for(int i = 0; i < n; i++){
                String line = in.nextLine();

                //String s = line.replaceAll("\\w+[,\\\\)]", "");
                String[] split = line.split("[ ,\\\\(]");
                StringBuilder sb = new StringBuilder();
                sb.append(split[1]);
                for(int j = 2; j < split.length;j+= 2){
                    sb.append(split[j]);
                }
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}

