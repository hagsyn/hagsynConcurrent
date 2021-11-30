package cn.hagsyn.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;

/**
 * @author admin
 * @date 2021/11/10
 */
public class ChangeValueInterceptorFactory {

    public static ChangeValueSetInterceptor getInterceptor(Object obj) {
        if (!(obj instanceof Factory)) {
            return null;
        }
        Factory f = (Factory) obj;
        Callback[] callBacks = f.getCallbacks();
        for (Callback callBack : callBacks) {
            if (callBack instanceof ChangeValueSetInterceptor) {
                return (ChangeValueSetInterceptor) callBack;
            }
        }
        return null;
    }
}
