package com.uttkarsh.DataMapping.controllers;

import com.uttkarsh.DataMapping.entities.DepartmentEntity;
import com.uttkarsh.DataMapping.entities.EmployeeEntity;
import com.uttkarsh.DataMapping.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentEntity> getAllDepartments(){
        return departmentService.getAll();
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(
            @PathVariable(name = "departmentId") Long id
    ){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentEntity createDepartment(
            @RequestBody DepartmentEntity departmentEntity
    ){
        return departmentService.createDepartment(departmentEntity);
    }

    @PutMapping(path = "/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long employeeId
    ){
        return departmentService.assignManagerToDepartment(departmentId, employeeId);
    }

    @GetMapping(path = "/assignedDepartment/{employeeId}")
    public DepartmentEntity getAssignedDepartment(
            @PathVariable Long employeeId
    ){
        return departmentService.getDepartment(employeeId);
    }
}
