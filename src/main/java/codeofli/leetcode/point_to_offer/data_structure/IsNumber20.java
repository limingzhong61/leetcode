package codeofli.leetcode.point_to_offer.data_structure;

import java.util.*;

public class IsNumber20 {

    /**
     * DFA
     * 注意：".1"是合法数字,但"."不是合法数字
     * e后面只能跟着整数
     */
    public boolean isNumber(String s) {
        char[] chars = s.trim().toCharArray();
        //全空“    ”为false
        if (chars.length == 0) {
            return false;
        }
        //构造DFA转移关系
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER);
            put(CharType.DOT, State.ONLY_DOT);
            put(CharType.SIGN, State.SIGNED);
        }};
        transfer.put(State.INIT, initialMap);

        Map<CharType, State> signedMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER);
            put(CharType.DOT, State.ONLY_DOT);
        }};
        transfer.put(State.SIGNED, signedMap);

        Map<CharType, State> onlyDotMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.DOT_NUMBER);
        }};
        transfer.put(State.ONLY_DOT, onlyDotMap);

        Map<CharType, State> numberMap = new HashMap<CharType, State>() {{
            put(CharType.DOT, State.NUMBER_DOT);
            put(CharType.E, State.E);
            put(CharType.NUMBER, State.NUMBER);
        }};
        transfer.put(State.NUMBER, numberMap);

        Map<CharType, State> dotMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.DOT_NUMBER);
            //NUMBER_DOT 能直接接e 如 "46.e3"
            put(CharType.E, State.E);
        }};
        transfer.put(State.NUMBER_DOT, dotMap);

        Map<CharType, State> dotNumberMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.DOT_NUMBER);
            put(CharType.E, State.E);
        }};
        transfer.put(State.DOT_NUMBER, dotNumberMap);

        Map<CharType, State> eMap = new HashMap<CharType, State>() {{
            put(CharType.SIGN, State.E_SIGNED);
            put(CharType.NUMBER, State.E_NUMBER);
        }};
        transfer.put(State.E, eMap);

        Map<CharType, State> eSignedMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.E_NUMBER);
        }};
        transfer.put(State.E_SIGNED, eSignedMap);

        Map<CharType, State> eNumberMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.E_NUMBER);
        }};
        transfer.put(State.E_NUMBER, eNumberMap);

        State state = State.INIT;
        for (int i = 0; i < chars.length; i++) {
            CharType type = toCharType(chars[i]);
            if (transfer.get(state).containsKey(type)) {
                state = transfer.get(state).get(type);
            } else {
                return false;
            }
        }
        //最后只能以数字, NUMBER_DOT结尾（ONLY_DOT不行）
        return state == State.NUMBER || state == State.E_NUMBER || state == State.DOT_NUMBER
                || state == State.NUMBER_DOT;
    }

    enum State {
        INIT,
        SIGNED,
        NUMBER,
        NUMBER_DOT,// 小数点左有整数
        ONLY_DOT, // 小数点左无整数
        DOT_NUMBER,
        E,
        E_SIGNED,
        E_NUMBER,
        END
    }

    enum CharType {
        SPACE,
        SIGN,
        NUMBER,
        DOT,
        E,
        ILLEGAL
    }

    private CharType toCharType(char c) {
        if (c == ' ') {
            return CharType.SPACE;
        } else if (c == '+' || c == '-') {
            return CharType.SIGN;
        } else if (Character.isDigit(c)) {
            return CharType.NUMBER;
        } else if (c == '.') {
            return CharType.DOT;
        } else if (c == 'e' || c == 'E') {
            return CharType.E;
        } else {
            return CharType.ILLEGAL;
        }
    }


    public static void main(String[] args) {
        IsNumber20 isNumber20 = new IsNumber20();
        Map<String, Boolean> testMap = new HashMap<>() {{
            put("0", true);
            put("e", false);
            put(".", false);
            put(" ", false);
            put(".1", true);
            put("0e", false);
            put(".e1", false);
            put("4e+", false);
            put(" -.", false);
            put("3.", true);
            put(" -.1", true);
            put(".20", true);
            put("46.e3", true);
            put(".2e81", true);
        }};
        for (Map.Entry<String, Boolean> testCase : testMap.entrySet()) {
            if (!isNumber20.isNumber(testCase.getKey()) == testCase.getValue()) {
                System.out.println("error:");
                System.out.println(testCase.getKey());
                System.out.println("计算结果值：" + isNumber20.isNumber(testCase.getKey()));
                System.out.println("真实结果值：" + testCase.getValue());

            }
        }
    }
}
