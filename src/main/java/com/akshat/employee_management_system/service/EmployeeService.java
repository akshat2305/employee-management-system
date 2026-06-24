package com.akshat.employee_management_system.service;
import com.akshat.employee_management_system.dto.EmployeeDTO;
import com.akshat.employee_management_system.exception.EmployeeNotFoundException;

import com.akshat.employee_management_system.entity.Employee;
import com.akshat.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (Employee employee : employees) {

            employeeDTOs.add(convertToDTO(employee));
        }

        return employeeDTOs;
    }

    public EmployeeDTO getEmployeeById(int id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        return convertToDTO(employee);
    }

    public EmployeeDTO addEmployee(Employee employee) {

        Employee savedEmployee = employeeRepository.save(employee);

        return convertToDTO(savedEmployee);
    }

    public EmployeeDTO updateEmployee(int id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return convertToDTO(updatedEmployee);
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