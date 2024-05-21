package org.example.emsbackend.controller;

import lombok.AllArgsConstructor;
import org.example.emsbackend.dto.EmployeeDto;
import org.example.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build add employee Rest APi
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    // BUILD GET EMPLOYEE WITH REST API

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long empId) {
        EmployeeDto employeeDto=employeeService.getEmployeeById(empId);
        return  ResponseEntity.ok(employeeDto);
    }

    // BUILD GET ALL EMPLOYEE WITH REST API
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeList=employeeService.getAllEmaployees();
        return ResponseEntity.ok(employeeList);
    }

    // BUILD UPDATE EMPLOYEE WITH REST API

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeId,employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    // BUILD DELETE EMPLOYEE WITH REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Delete Successfully!!");
    }
}
