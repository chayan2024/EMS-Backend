package org.example.emsbackend.mapper;

import org.example.emsbackend.dto.EmployeeDto;
import org.example.emsbackend.entity.Employee;

public class Employeemapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employee) {

        return new Employee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone()
        );
    }
}
