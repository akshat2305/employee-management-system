package com.akshat.employee_management_system.repository;

import com.akshat.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {

    List<Employee> findByDepartment(String department);

    List<Employee> findByNameContainingIgnoreCase(String keyword);
}