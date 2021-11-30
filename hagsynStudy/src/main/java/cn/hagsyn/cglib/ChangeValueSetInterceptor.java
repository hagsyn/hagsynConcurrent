package cn.hagsyn.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2021/11/10
 */
public class ChangeValueSetInterceptor implements MethodInterceptor {

    private static final String SET = "set";
    private Map<String, Object[]> changedPropMap;

    public ChangeValueSetInterceptor() {
        changedPropMap = new HashMap<String, Object[]>();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        String name = method.getName();
        Object pobj = proxy.invokeSuper(obj, args);
        if (name.startsWith(SET)) {
            changedPropMap.put(name, args);
        }
        return pobj;
    }

    public Map<String, Object[]> getChangedPropMap() {
        return Collections.unmodifiableMap(changedPropMap);
    }
}
