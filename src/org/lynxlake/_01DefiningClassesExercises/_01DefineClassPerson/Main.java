// https://judge.softuni.bg/Contests/Practice/Index/230#0
package org.lynxlake._01DefiningClassesExercises._01DefineClassPerson;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
