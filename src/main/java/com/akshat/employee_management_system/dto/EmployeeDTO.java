package com.akshat.employee_management_system.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private int id;
    private String name;
    private String email;
    private String department;
}