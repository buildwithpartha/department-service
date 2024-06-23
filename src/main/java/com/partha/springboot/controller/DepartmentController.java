package com.partha.springboot.controller;


import com.partha.springboot.dto.DepartmentDto;
import com.partha.springboot.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Department Controller", description = "This is the Department Controller")
@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        return  new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByDepartmentCode(@PathVariable("department-code") String departmentCode){
        return  new ResponseEntity<>(departmentService.getDepartmentByDepartmentCode(departmentCode), HttpStatus.OK );
    }

}
