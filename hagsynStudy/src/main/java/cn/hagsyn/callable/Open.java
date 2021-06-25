package cn.hagsyn.callable;

import java.lang.reflect.Modifier;

public interface Open {
    public static interface create {
        public static interface Input {

        }
    }

    public static interface update {
        public static interface Input {

        }
    }

    public static void main(String[] args) {
        Class[] declaredClasses = Open.class.getDeclaredClasses();
        for (Class declaredClass : declaredClasses) {
            int mod = declaredClass.getModifiers();
            String modifier = Modifier.toString(mod);
            if (modifier.contains("static")) {
                Class[] declaredClasses1 = declaredClass.getDeclaredClasses();
                for (Class declared : declaredClasses1) {
                    System.out.println(declared.getSimpleName());
                }
            }
        }

    }
}
