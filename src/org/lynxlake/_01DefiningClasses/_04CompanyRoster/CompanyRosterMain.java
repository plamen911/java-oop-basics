// https://judge.softuni.bg/Contests/Practice/Index/230#3
package org.lynxlake._01DefiningClasses._04CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CompanyRosterMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> departmentsWithSalary = new HashMap<>();
        HashMap<String, TreeSet<Employee>> departmentsWithEmloyees = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split("\\s+");
            String name = params[0];
            double salary = Double.valueOf(params[1]);
            String position = params[2];
            String department = params[3];

            Employee employee = null;
            if (params.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (params.length == 5) {
                try {
                    int age = Integer.valueOf(params[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (Exception e) {
                    String email = params[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                String email = params[4];
                int age = Integer.valueOf(params[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            if (!departmentsWithSalary.containsKey(department)) {
                departmentsWithSalary.put(department, 0.0);
                departmentsWithEmloyees.put(department, new TreeSet<>());
            }
            departmentsWithSalary.put(department, departmentsWithSalary.get(department) + salary);
            departmentsWithEmloyees.get(department).add(employee);
        }

        // sort by department with the highest average salary
        Map.Entry<String, TreeSet<Employee>> best = departmentsWithEmloyees
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(departmentsWithSalary.get(e2.getKey()), departmentsWithSalary.get(e1.getKey())))
                .findFirst()
                .get();

        System.out.printf("Highest Average Salary: %s%n", best.getKey());
        for (Employee employee : best.getValue()) {
            System.out.printf("%s%n", employee);
        }
    }
}
