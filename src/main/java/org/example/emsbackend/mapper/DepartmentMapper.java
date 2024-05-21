package org.example.emsbackend.mapper;

import org.example.emsbackend.dto.DepartmentDto;
import org.example.emsbackend.entity.Department;

public class DepartmentMapper {

    // convert department jpa into department dto

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentDescription());
    }

    // convert department dto to department jpa entitiy-

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(departmentDto.getDepartmentId(),departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription());
    }

}
