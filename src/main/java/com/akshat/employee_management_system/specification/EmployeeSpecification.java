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

    public static Specification<Employee> hasNameContaining(String name) {

        return (root, query, criteriaBuilder) -> {

            if (name == null || name.isBlank()) {
                return null;
            }

            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + name.toLowerCase() + "%"
            );
        };
    }

    public static Specification<Employee> hasEmailContaining(String email) {

        return (root, query, criteriaBuilder) -> {

            if (email == null || email.isBlank()) {
                return null;
            }

            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("email")),
                    "%" + email.toLowerCase() + "%"
            );
        };
    }

    /**
     * Combines any subset of the above filters. Any parameter left null/blank
     * is simply skipped, so callers can pass any combination of criteria.
     */
    public static Specification<Employee> filterBy(String department, String name, String email) {

        return Specification.allOf(
                hasDepartment(department),
                hasNameContaining(name),
                hasEmailContaining(email)
        );
    }
}