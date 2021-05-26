package peaner.yier.utils.test.practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Peaner
 * @time: 2021/5/21
 * @description:
 */
public class Demo001 {

    public static void main(String[] args) throws Exception {
        test001();
    }

    private static void test001() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list= new ArrayList<>();
        list.add(1);
        Method method = list.getClass().getDeclaredMethod("add", Object.class);
        method.invoke(list, "ls");
        System.out.println(list);
    }

}
