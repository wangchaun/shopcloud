package com.maiya.shopcloud.base.utils;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 功能描述：	对于有些没有公开的set方法，通过Hack Style利用反射绕过Java硬编码的访问控制
 *
 * @author  mandy.hu
 */
public abstract class ReflectUtils {
    private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

    @SuppressWarnings("unchecked")
    public static void setFieldValue(Object target, String name, Class type,
                                     Object value) {
        // 判断出入的参数有效性
        if (target == null
                || Strings.isNullOrEmpty(name)
                || (value != null && !type
                .isAssignableFrom(value.getClass()))) {
            return;
        }

        // 调用类对应的Setter方法
        Class clazz = target.getClass();
        try {
            Method method = clazz.getDeclaredMethod("set"
                    + Character.toUpperCase(name.charAt(0))
                    + name.substring(1), type);

            if (!Modifier.isPublic(method.getModifiers())) {
                method.setAccessible(true);
            }

            method.invoke(target, value);
        } catch (Exception me) {
            // Double Checking
            //logger.debug("没有Setter[" + fname + "]方法：" + me);

            // 如果没有对应的Setter方法，则直接设置对应的类成员变量字段
            try {
                Field field = clazz.getDeclaredField(name);

                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }

                field.set(target, value);
            } catch (Exception fe) {
                logger.debug(fe.getMessage(), fe);
            }
        }
    }
}
