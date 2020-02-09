package io.evenX86.github.bytecode.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created with design-pattern-training
 * <p>
 * 反射实现原理实践
 *
 * @author xuyifei
 * @date 2020-02-03 9:01 下午
 */
public class Test {

    public static void target(int i) {

    }

    public static void reflectTest1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class klass = Class.forName("io.evenX86.github.bytecode.reflect.Test");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 128);
    }

    public static void reflectMeature() throws Exception {
        Class klass = Class.forName("io.evenX86.github.bytecode.reflect.Test");
        Method method = klass.getMethod("target", int.class);
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(i + " : " + (temp - current) + " ms");
                current = temp;
            }
            method.invoke(null, 128);
        }
    }

    public static void main(String[] args) throws Exception {
        printField();
    }

    public static void printField() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String className = SonClass.class.getName();
        System.out.println("class name : " + className);

        // getFields 得到的是public 的变量
        Field[] fields = SonClass.class.getFields();
        // getDeclaredFields 得到当前类的所有字段
        Field[] declaredFields = SonClass.class.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("modifier : " + field.getModifiers());
            System.out.println("变量类型: " + field.getType().getName() + " 变量名: " + field.getName());
        }
        System.out.println("------------------");
        /*for (Field field : declaredFields) {
            System.out.println("declaredFields modifier : " + field.getModifiers());
            System.out.println("declaredFields 变量类型: " + field.getType().getName() + " 变量名: " + field.getName());
        }*/

        Method[] method = SonClass.class.getMethods();
        Method[] declaredMethods = SonClass.class.getDeclaredMethods();

        //printMethod(method);
        //printMethod(declaredMethods);

        //printPrivateMethod();

        modifyPrivateMethodField();

    }

    private static void printPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SonClass sonClass = new SonClass();
        Class clazz = sonClass.getClass();
        Method privateMethod = clazz.getDeclaredMethod("privateMethod", String.class, int.class);

        if (privateMethod != null) {
            // 设置访问权限
            // 不设置，会抛出 IllegalAccessException
            privateMethod.setAccessible(true);
            privateMethod.invoke(sonClass, "Reflect", 6);
        }
    }

    private static void modifyPrivateMethodField() throws NoSuchFieldException, IllegalAccessException {
        SonClass son = new SonClass();
        Class clazz = son.getClass();
        Field field = clazz.getDeclaredField("FIN_MSG");
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        System.out.println("before modify field : " + son.getFIN_MSG());
        field.set(son, "1234");
        // 输出 1234
        System.out.println("ini.t ： " + field.get(son));
        // 实际未改变,因为编译器优化
        System.out.println("after modify field : " + son.getFIN_MSG());
    }

    private static void printMethod(Method[] mMethods) {
        for (Method method : mMethods) {
            System.out.println("modify : " + method.getModifiers());
            System.out.println("return type : " + method.getReturnType().getName());
            System.out.println("method name : " + method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getType().getName() + " " + parameter.getName() + ", ");
            }
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0) {
                System.out.println(" no exception ");
            } else {
                for (Class c : exceptionTypes ) {
                    System.out.println("throws : " + c.getName());
                }
            }
        }
    }
}
