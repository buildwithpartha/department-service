package com.partha.springboot.service.impl;

import com.partha.springboot.dto.DepartmentDto;
import com.partha.springboot.entity.Department;
import com.partha.springboot.mapper.DepartmentMapper;
import com.partha.springboot.repository.DepartmentRepository;
import com.partha.springboot.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        //Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
        //        departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

        //Department department = modelMapper.map(departmentDto, Department.class);
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        //DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(), savedDepartment.getDepartmentName(),
        //        savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode());

        //DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        //DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
        //        department.getDepartmentDescription(), department.getDepartmentCode());
        //DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
