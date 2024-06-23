package com.partha.springboot.service;

import com.partha.springboot.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByDepartmentCode(String departmentCode);
}
