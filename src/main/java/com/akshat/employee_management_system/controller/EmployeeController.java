package com.akshat.employee_management_system.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.akshat.employee_management_system.dto.EmployeeRequestDTO;
import com.akshat.employee_management_system.dto.EmployeeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.akshat.employee_management_system.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<EmployeeResponseDTO>> getAllEmployeesPaginated(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sort)
        );

        return ResponseEntity.ok(
                employeeService.getAllEmployees(pageable));
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment(
            @PathVariable String department) {

        return ResponseEntity.ok(
                employeeService.getEmployeesByDepartment(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable int id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponseDTO>> searchEmployees(
            @RequestParam String keyword) {

        return ResponseEntity.ok(
                employeeService.searchEmployees(keyword));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> addEmployee(
            @Valid @RequestBody EmployeeRequestDTO request) {

        return ResponseEntity.ok(employeeService.addEmployee(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable int id,
            @RequestBody @Valid EmployeeRequestDTO request) {

        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
    }