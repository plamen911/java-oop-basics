// https://judge.softuni.bg/Contests/Practice/Index/225#7
package org.lynxlake.methods.immutableList;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class listClass = ImmutableList.class;
        Field[] fields = listClass.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        }

        Method method = listClass.getDeclaredMethods()[0];
        System.out.println(method.getReturnType().getSimpleName());
    }
}
