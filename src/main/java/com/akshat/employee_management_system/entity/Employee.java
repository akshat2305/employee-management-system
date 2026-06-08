package com.akshat.employee_management_system.entity;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private String email;
    private String department;
}