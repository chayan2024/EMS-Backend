package org.example.emsbackend.service;

import lombok.AllArgsConstructor;
import org.example.emsbackend.dto.DepartmentDto;
import org.example.emsbackend.entity.Department;
import org.example.emsbackend.exception.ResourceNotFoundException;
import org.example.emsbackend.mapper.DepartmentMapper;
import org.example.emsbackend.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(long departmentId){
        Department department=departRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("No department found with id: "+departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }


    @Override
    public List<DepartmentDto> getAllDepartments(){
        List<Department> departments=departRepository.findAll();
        return departments.stream().map((DepartmentMapper::mapToDepartmentDto)).collect(Collectors.toList());
    }
    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, long id) {
        return null;
    }

    @Override
    public void deleteDepartment(long departmentId) {
        Department department=departRepository.findById(departmentId).orElseThrow(()->new ResourceNotFoundException("No department found with id: "+departmentId));
        departRepository.deleteById(departmentId);
    }
}
