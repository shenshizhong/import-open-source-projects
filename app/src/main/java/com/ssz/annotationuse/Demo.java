package com.ssz.annotationuse;

import java.lang.reflect.Field;

/**
 * Created by dell on 2017/6/29.
 */

public class Demo {
    @Student(id="01",name="ssz")//多个成员用","隔开
    private String student;
//     可以只有一个成员
//    @Student(id="02")
//    private String id;
    public static void main(String[] args){
        try {
            Class<?> cls = Class.forName("com.ssz.annotationuse.Demo");
            Field[] declaredFields = cls.getDeclaredFields();
            for(Field field : declaredFields){
                Student annotation = field.getAnnotation(Student.class);
                if(annotation!=null){
                    String id = annotation.id();
                    String name = annotation.name();
                    System.out.println("id的值："+id);
                    System.out.println("name的值："+name);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
