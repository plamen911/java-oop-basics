// https://judge.softuni.bg/Contests/Practice/Index/225#9
package org.lynxlake.methods.pizzaTime;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();
        reader.close();

        Pizza pizza = new Pizza();
        HashMap<Integer, LinkedList<String>> pizzaList = pizza.parseInput(line);

        for (Map.Entry<Integer, LinkedList<String>> entry: pizzaList.entrySet()) {
            System.out.printf("%d - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }

        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }
    }
}
