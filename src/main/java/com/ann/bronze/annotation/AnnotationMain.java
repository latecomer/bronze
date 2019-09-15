package com.ann.bronze.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description //TODO
 * @Author anzongying
 * @Date 19:45 2019-09-15
 **/

public class AnnotationMain {
    public static void main(String[] args) throws NoSuchMethodException {
        //获取类上注解
        boolean hasMyAnnotation = AnnotaionDemo.class.isAnnotationPresent(MyAnnotation.class);
        if (hasMyAnnotation) {
            MyAnnotation myAnnotation = AnnotaionDemo.class.getAnnotation(MyAnnotation.class);
            System.out.println("类注解：" + myAnnotation.value());
        }

        try {
            //获取域上注解
            Field field = AnnotaionDemo.class.getDeclaredField("name");
            boolean hasFieldAnnotation = field.isAnnotationPresent(MyAnnotation.class);
            if (hasFieldAnnotation) {
                MyAnnotation fieldAnnotation = field.getAnnotation(MyAnnotation.class);
                System.out.println("域注解：" + fieldAnnotation.value());
            }

            Method method = AnnotaionDemo.class.getDeclaredMethod("getName");
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyAnnotation) {
                    System.out.println("方法注解" + ((MyAnnotation)annotation).value());
                }
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
