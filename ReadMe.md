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
    
# step 2

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

# use of Predicate

    package com.model;
    
    import java.util.function.DoublePredicate;
    import java.util.function.IntPredicate;
    
    /**
     * Created by Adwiti on 4/12/2018.
     */
    public class TypesOfPredicate {
        public static void main(String[] args) {
    
            IntPredicate greaterThan15 = i -> i > 15;
            System.out.println(greaterThan15.test(10)); //false
    
            IntPredicate lessThan100 = i -> i < 100;
            System.out.println(lessThan100.test(50)); //true
    
            boolean flag = lessThan100.and(greaterThan15).test(25);
            System.out.println(flag); //returns true
    
            flag = lessThan100.or(greaterThan15).test(5);
            System.out.println(flag); //returns true
    
            flag = lessThan100.negate().test(101);
            System.out.println(flag); //returns true
    
            DoublePredicate greaterThan12 = i -> i > 12.0;
            System.out.println(greaterThan12.test(13.1)); //returns true
        }
    }
