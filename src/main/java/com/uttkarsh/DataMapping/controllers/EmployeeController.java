package com.uttkarsh.DataMapping.controllers;

import com.uttkarsh.DataMapping.entities.DepartmentEntity;
import com.uttkarsh.DataMapping.entities.EmployeeEntity;
import com.uttkarsh.DataMapping.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeEntity> getALl(){
        return employeeService.getAll();
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(
            @PathVariable(name = "employeeId") Long id
    ){
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public EmployeeEntity createEmployee(
            @RequestBody EmployeeEntity employeeEntity
    ){
        return employeeService.createEmployee(employeeEntity);
    }


}
