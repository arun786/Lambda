# Lambda

    package com.model;
    
    /**
     * Created by Adwiti on 4/12/2018.
     */
    public class Employee {
    
        private String name;
        private int age;
    
        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        public String getName() {
            return name;
        }
    
        public int getAge() {
            return age;
        }
    }

# step 1

    {
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
    
        /*forEach accepts a Consumer, Consumer is a functional interface
        which has accept as an abstract method which accepts a parameter and returns a void*/
    
        /**
         * To filter out employees who are more than 30
         */
    
        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName() + ": " + employee.getAge());
            }
        });
    
        /**
         * To filter out employees who are less than 30
         */
        employees.forEach(employee -> {
            if (employee.getAge() < 30) {
                System.out.println(employee.getName() + ": " + employee.getAge());
            }
        });
    }