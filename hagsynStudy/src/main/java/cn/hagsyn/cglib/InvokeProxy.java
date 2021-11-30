package cn.hagsyn.cglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author admin
 * @date 2021/11/10
 */
public class InvokeProxy {

    public static void invokeChangeValue(Object sobject, Object nobject, ChangeValueSetInterceptor interceptor) throws Exception {
        if (sobject == null && nobject == null && interceptor == null)
            return;
        Map<String, Object[]> map = interceptor.getChangedPropMap();
        if (map == null || map.size() == 0)
            return;
        Method[] methoerds = nobject.getClass().getMethods();
        for (Method m : methoerds) {
            String setMethodName = m.getName();
            Object[] paramsValues = map.get(setMethodName);
            if (paramsValues != null && paramsValues.length > 0) {
                try {
                    Method setMethod = nobject.getClass().getMethod(setMethodName, m.getParameterTypes());
                    if (setMethod != null) {
                        setMethod.invoke(nobject, paramsValues);
                    }
                } catch (InvocationTargetException e) {
                    throw new InvocationTargetException(e);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                } catch (SecurityException e) {
                    throw new SecurityException(e);
                } catch (IllegalAccessException e) {
                    throw new IllegalAccessException();
                } catch (NoSuchMethodException e) {
                    throw new NoSuchMethodException();
                }
            }

        }
    }

}
