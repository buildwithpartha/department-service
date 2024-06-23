package com.partha.springboot.mapper;

import com.partha.springboot.dto.DepartmentDto;
import com.partha.springboot.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    public static DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);


}
