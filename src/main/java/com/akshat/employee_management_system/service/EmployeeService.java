package com.akshat.employee_management_system.service;
import com.akshat.employee_management_system.dto.EmployeeDTO;
import com.akshat.employee_management_system.exception.EmployeeNotFoundException;

import com.akshat.employee_management_system.entity.Employee;
import com.akshat.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeDTO getEmployeeById(int id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        return convertToDTO(employee);
    }

    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(int id) {

        employeeRepository.deleteById(id);
    }

    private EmployeeDTO convertToDTO(Employee employee) {

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());

        return dto;
    }

    }