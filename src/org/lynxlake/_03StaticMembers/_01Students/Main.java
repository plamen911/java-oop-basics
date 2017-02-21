// https://judge.softuni.bg/Contests/Practice/Index/231#0
package org.lynxlake._03StaticMembers._01Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();
        while (!line.equalsIgnoreCase("End")) {
            Student student = new Student(line);
            line = reader.readLine().trim();
        }
        reader.close();

        System.out.println(Student.numStudentInstances);
    }
}
