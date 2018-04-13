package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Adwiti on 4/12/2018.
 */
public class useOfPredicate {
    public static void main(String[] args) {
        Employee e1 = new Employee("arun", 31);
        Employee e2 = new Employee("sachin", 45);
        Employee e3 = new Employee("dhoni", 36);
        Employee e4 = new Employee("rahul", 4);
        Employee e5 = new Employee("adwiti", 3);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        printEmployeeByAge(employees, "Employee greater than 30", employee -> employee.getAge() > 30);
        printEmployeeByAge(employees, "\nEmployee less than 30", employee -> employee.getAge() < 30);

        //We can also use anonymous class instead of lambda

        printEmployeeByAge(employees, "\nEmployee less than 4", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 4;
            }
        });

    }

    public static void printEmployeeByAge(List<Employee> employees, String textCondition, Predicate<Employee> ageCondition) {
        System.out.println(textCondition);
        System.out.println("-------------------");
        for (Employee emp : employees) {
            if (ageCondition.test(emp)) {
                System.out.println(emp.getName() + ": " + emp.getAge());
            }
        }
    }
}
