package com.akshat.employee_management_system.controller;

import com.akshat.employee_management_system.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeController() {

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Akshat");
        employee1.setEmail("akshat@gmail.com");
        employee1.setDepartment("Engineering");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Rahul");
        employee2.setEmail("rahul@gmail.com");
        employee2.setDepartment("Commerce");

        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setName("Shreya");
        employee3.setEmail("shreya@gmail.com");
        employee3.setDepartment("Designing");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                return employee;
            }

        }

        throw new RuntimeException("Employee not found");
    }
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {

        employees.add(employee);

        return employee;
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,
                                   @RequestBody Employee employee) {

        for (Employee existingEmployee : employees) {

            if (existingEmployee.getId() == id) {

                existingEmployee.setName(employee.getName());
                existingEmployee.setEmail(employee.getEmail());
                existingEmployee.setDepartment(employee.getDepartment());

                return existingEmployee;
            }
        }

        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {

        Employee employeeToDelete = null;

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                employeeToDelete = employee;
            }

        }

        employees.remove(employeeToDelete);
    }
}