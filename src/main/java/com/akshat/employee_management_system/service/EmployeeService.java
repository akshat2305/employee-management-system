package com.akshat.employee_management_system.service;

import com.akshat.employee_management_system.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();


        public EmployeeService() {

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
    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                return employee;
            }

        }

        throw new RuntimeException("Employee not found");
    }

    public Employee addEmployee(Employee employee) {

        employees.add(employee);

        return employee;
    }

    public Employee updateEmployee(int id, Employee employee) {

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
    public void deleteEmployee(int id) {

        Employee employeeToDelete = null;

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                employeeToDelete = employee;
            }

        }

        employees.remove(employeeToDelete);
    }


    }