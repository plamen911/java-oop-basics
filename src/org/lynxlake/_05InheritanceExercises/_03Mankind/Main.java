// https://judge.softuni.bg/Contests/Practice/Index/226#2
package org.lynxlake._05InheritanceExercises._03Mankind;

import org.lynxlake._05InheritanceExercises._03Mankind.models.Student;
import org.lynxlake._05InheritanceExercises._03Mankind.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params;
        String firstName;
        String lastName;

        try {
            params = reader.readLine().trim().split("\\s+");
            firstName = params[0];
            lastName = params[1];
            String facultyNumber = params[2];

            Student student = new Student(firstName, lastName, facultyNumber);
            System.out.println(student.toString());// // Print the student info

            System.out.println();

            params = reader.readLine().trim().split("\\s+");
            firstName = params[0];
            lastName = params[1];
            double weekSalary = Double.parseDouble(params[2]);
            double workHoursPerDay = Double.parseDouble(params[3]);

            Worker worker = new Worker(firstName, lastName, weekSalary, workHoursPerDay);
            System.out.println(worker.toString());// // Print the worker info

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
