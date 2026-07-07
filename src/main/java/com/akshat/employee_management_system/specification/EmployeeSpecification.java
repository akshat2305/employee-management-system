package com.akshat.employee_management_system.specification;
import com.akshat.employee_management_system.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    public static Specification<Employee> hasDepartment(String department) {

        return (root, query, criteriaBuilder) -> {

            if (department == null || department.isBlank()) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("department"),
                    department
            );
        };
    }
}