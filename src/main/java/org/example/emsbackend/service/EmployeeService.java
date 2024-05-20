package org.example.emsbackend.service;

import org.example.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmaployees();

    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);

    void deleteEmployee(Long id);
}
