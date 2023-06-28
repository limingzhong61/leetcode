package interview.meituan;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: limingzhong
 * @create: 2023-04-21 10:43
 */
public class TestClass {
    private static int statGoodScoreCount(List<Integer> scoreList) {
        return  scoreList.stream().filter(e -> e >= 85).toList().size();
    }
    public static void main(String[] args) {
        List<Integer> scoreList = Stream.of(90, 78, 65, 98, 83, 88, 61, 53).toList();
        System.out.println(statGoodScoreCount(scoreList));
    }

}
