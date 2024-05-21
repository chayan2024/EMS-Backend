package org.example.emsbackend.service;

import org.example.emsbackend.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(long id);

    DepartmentDto updateDepartment(DepartmentDto departmentDto,long id);

    void deleteDepartment(long id);

    List<DepartmentDto> getAllDepartments();
}
