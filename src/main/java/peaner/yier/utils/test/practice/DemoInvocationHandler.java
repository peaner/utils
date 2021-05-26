package peaner.yier.utils.test.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Peaner
 * @time: 2021/5/24
 * @description:
 */
public class DemoInvocationHandler implements InvocationHandler {

    private final Object target;

    public DemoInvocationHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;
    }
}
