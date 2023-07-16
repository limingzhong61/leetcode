package com.lmz.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-07-10 11:28
 */
public class TestCaseUtil {
    private static <T,R> boolean testCase(Object o,T targetClass,final String methodName,Object[] args,Class<?>[] argsTypes,
                                          Object result,R resultType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        T t = (T) o;
        Class<?> clazz = t.getClass();
        Method declaredMethod = clazz.getDeclaredMethod(methodName, argsTypes);
        R result1 = (R) declaredMethod.invoke(o, args);
        if(result1.equals(result)){
            System.out.println(Arrays.toString(args));
            System.out.println(result);
            return true;
        }
        return false;
    }
}
