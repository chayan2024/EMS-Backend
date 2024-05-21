package org.example.emsbackend.controller;

import lombok.AllArgsConstructor;
import org.example.emsbackend.dto.DepartmentDto;
import org.example.emsbackend.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto departmentDto1 = departmentService.createDepartment(departmentDto);
        return ResponseEntity.ok(departmentDto1);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        DepartmentDto departmentDto = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping("/allDepartments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully");
    }
}
