package mars.my;

import java.util.*;

public class RandChar {
    public static HashSet<String> result = new HashSet<>();
    public  static char[] chars;
     static boolean[] choose = new boolean[101];
    //static  int size = 0;
    public  static void getRandomChar(int size, int length){
        if(size == 0) {
            //result.add(sb);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < length; i++){
                if(choose[i]){
                    sb.append(chars[i]);
                }
            }
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i < length; i++){
            if(!choose[i]){ //没备选
                choose[i] = true;
                getRandomChar(size-1,length);
                choose[i] = false;
            }

        }
    }
    public  static void getRandomCharWithOrder(int size,int cur, int length){
        if(size == 0) {
            //result.add(sb);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < length; i++){
                if(choose[i]){
                    sb.append(chars[i]);
                }
            }
            if(isExclude(sb.toString())){
                return;
            }
            result.add(sb.toString());
            return;
        }
        for(int i = cur; i < length; i++){
            if(!choose[i]){ //没备选
                choose[i] = true;
                getRandomCharWithOrder(size-1,cur+1,length);
                choose[i] = false;
            }

        }
    }
    public  static  boolean isExclude(String s){
        //排除在外的字符
        ArrayList<String>  excludeList = new ArrayList<>();
        excludeList.add("li");

        excludeList.add("min");
        excludeList.add("ing");

        excludeList.add("zho");
        excludeList.add("hon");
        excludeList.add("ong");
        for(String str : excludeList){
            if(s.contains(str)){
                return  true;
            }
            if(s.startsWith("i")){
                return true;
            }
            if(s.startsWith("l")){
                return true;
            }
            //if(s.startsWith("l")){
            //    return true;
            //}
            if(s.endsWith("ng")){
                return true;
            }
            //if(s.endsWith("z")){
            //    return true;
            //}
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();
        System.out.println(next);
        chars = next.toCharArray();
        int n = chars.length;
        System.out.println("string.length=" +n);
        int size = 4;
        //getRandomChar(size,n);
        getRandomCharWithOrder(size,0,n);
        //System.out.println(Arrays.toString(choose));
        getRandomCharWithOrder(5,0,n);
        System.out.println(result.size());

        for(String s : result){
            //if(s.startsWith("mi")){
                System.out.println(s);
            //}

        }
    }
}
