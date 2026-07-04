package com.akshat.employee_management_system.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Management System API",
                version = "1.0",
                description = "REST APIs for managing employees using Spring Boot.",
                contact = @Contact(
                        name = "Akshat Khanna",
                        email = "akshat23khanna@gmail.com"
                )
        )
)
public class OpenApiConfig {
}