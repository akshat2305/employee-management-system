package com.akshat.employee_management_system.service;
import com.akshat.employee_management_system.dto.EmployeeRequestDTO;
import com.akshat.employee_management_system.dto.EmployeeResponseDTO;
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

    public List<EmployeeResponseDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponseDTO> employeeResponseDTOS = new ArrayList<>();

        for (Employee employee : employees) {

            employeeResponseDTOS.add(convertToResponseDTO(employee));
        }

        return employeeResponseDTOS;
    }

    public EmployeeResponseDTO getEmployeeById(int id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        return convertToResponseDTO(employee);
    }

    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO request) {

        Employee employee = convertToEntity(request);

        Employee savedEmployee = employeeRepository.save(employee);

        return convertToResponseDTO(savedEmployee);
    }

    public EmployeeResponseDTO updateEmployee(int id, EmployeeRequestDTO request) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        existingEmployee.setName(request.getName());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setDepartment(request.getDepartment());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return convertToResponseDTO(updatedEmployee);
    }

    public void deleteEmployee(int id) {

        employeeRepository.deleteById(id);
    }

    private EmployeeResponseDTO convertToResponseDTO(Employee employee) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());

        return dto;
    }

    private Employee convertToEntity(EmployeeRequestDTO request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(request.getDepartment());

        return employee;
    }

    }