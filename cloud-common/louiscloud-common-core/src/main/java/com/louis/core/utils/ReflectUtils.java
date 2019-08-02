package com.louis.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author John·Louis
 * @date create in 2019/5/30
 *  description: 反射工具类
 */
@Slf4j
public class ReflectUtils {

    /**
     * 得到指定类型的指定位置的泛型实参
     *
     * @param clazz
     * @param index
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> findParameterizedType(Class<?> clazz, int index) {
        Type parameterizedType = clazz.getGenericSuperclass();
        //CGLUB subclass target object(泛型在父类上)
        if (!(parameterizedType instanceof ParameterizedType)) {
            parameterizedType = clazz.getSuperclass().getGenericSuperclass();
        }
        if (!(parameterizedType instanceof  ParameterizedType)) {
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) parameterizedType).getActualTypeArguments();
        if (actualTypeArguments == null || actualTypeArguments.length == 0) {
            return null;
        }
        return (Class<T>) actualTypeArguments[index];
    }

    /**
     * 通过反射调用某个方法
     * @param object 调用的对象
     * @param methodName 调用的方法名
     * @param parameterTypes 调用的参数名
     * @param parameterValue 调用的参数值
     * @return T
     */
    public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameterValue) {

        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        if (Objects.nonNull(method)) {
            method.setAccessible(true);
            try {
                return method.invoke(object, parameterValue);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e.getMessage());
            }
        } else {
            log.error("get declared method error: className：{}，methodName:{}", object.getClass().getName(), methodName);
        }
        return null;

    }

    /**
     * 通过反射获取方法声明
     * @param object 类名
     * @param methodName 方法名
     * @param parameterTypes 参数类型
     * @return 方法
     */
    private static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                return clazz.getDeclaredMethod(methodName, parameterTypes);
            } catch (Exception e) {
                log.warn("Get declared method warning:{} ,methodName->{}",clazz.getName() ,methodName);
            }
        }
        return null;
    }

}
