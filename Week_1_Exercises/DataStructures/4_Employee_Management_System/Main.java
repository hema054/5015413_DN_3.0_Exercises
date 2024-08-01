package CTS_Weekly_Exercies.Week1_DSA.Employee_Management_System;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        Employee employee1 = new Employee(1, "John Doe", "Software Engineer", 100000.0);
        Employee employee2 = new Employee(2, "Jane Doe", "Data Scientist", 120000.0);
        Employee employee3 = new Employee(3, "Bob Smith", "Product Manager", 150000.0);

        ems.addEmployee(employee1);
        ems.addEmployee(employee2);
        ems.addEmployee(employee3);

        ems.traverseEmployees();

        Employee foundEmployee = ems.searchEmployee(2);
        if (foundEmployee != null) {
            System.out.println("Found employee: " + foundEmployee.getName());
        } else {
            System.out.println("Employee not found");
        }

        ems.deleteEmployee(2);
        ems.traverseEmployees();
    }
}