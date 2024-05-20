package org.example.emsbackend.service;

import lombok.AllArgsConstructor;
import org.example.emsbackend.exception.ResourceNotFoundException;
import org.example.emsbackend.repository.EmployeeRepository;
import org.example.emsbackend.dto.EmployeeDto;
import org.example.emsbackend.entity.Employee;
import org.example.emsbackend.mapper.Employeemapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= Employeemapper.mapToEmployee(employeeDto);

        Employee saveEmployee= employeeRepository.save(employee);

        return Employeemapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee is not Exists with Given Id:" +id));
        return Employeemapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmaployees() {

        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee -> Employeemapper.mapToEmployeeDto(employee))).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployeeDto) {

        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee is not Exists with Given Id:" +id));
        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        employee.setPhone(updatedEmployeeDto.getPhone());
        Employee updateEmployee= employeeRepository.save(employee);
        return Employeemapper.mapToEmployeeDto(updateEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee is not Exists with Given Id:" +id));
        employeeRepository.delete(employee);
     }
}
