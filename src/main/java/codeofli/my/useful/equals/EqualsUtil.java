package codeofli.my.useful.equals;

import codeofli.my.useful.ArraysUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualsUtil {
    /**
     * 比较两个列表元素是否相同，忽略元素位置
     * @param list1
     * @param list2
     * @return
     */
    public static boolean EqualIgnoreOrder(List<Integer> list1, ArrayList<Integer> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }
}
