package com.akshat.employee_management_system.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(
        name = "Employee Management",
        description = "REST APIs for managing employees"
)
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Retrieve all employees",
            description = "Returns the complete list of employees."
    )
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Operation(
            summary = "Retrieve employees with pagination",
            description = "Returns paginated employees with optional sorting."
    )
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

    @Operation(
            summary = "Retrieve employees by department",
            description = "Returns all employees belonging to the specified department."
    )
    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment(
            @PathVariable String department) {

        return ResponseEntity.ok(
                employeeService.getEmployeesByDepartment(department));
    }

    @Operation(
            summary = "Get employee by ID",
            description = "Returns an employee if the given ID exists."
    )
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable int id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @Operation(
            summary = "Search employees",
            description = "Searches employees by name using a case-insensitive keyword."
    )
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponseDTO>> searchEmployees(
            @RequestParam String keyword) {

        return ResponseEntity.ok(
                employeeService.searchEmployees(keyword));
    }

    @Operation(
            summary = "Create employee",
            description = "Creates a new employee."
    )
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> addEmployee(
            @Valid @RequestBody EmployeeRequestDTO request) {

        return ResponseEntity.ok(employeeService.addEmployee(request));
    }

    @Operation(
            summary = "Update employee",
            description = "Updates an existing employee."
    )
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable int id,
            @RequestBody @Valid EmployeeRequestDTO request) {

        return ResponseEntity.ok(employeeService.updateEmployee(id, request));
    }

    @Operation(
            summary = "Delete employee",
            description = "Deletes an employee by ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
    }