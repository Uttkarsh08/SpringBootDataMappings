package com.uttkarsh.DataMapping.services;

import com.uttkarsh.DataMapping.entities.DepartmentEntity;
import com.uttkarsh.DataMapping.entities.EmployeeEntity;
import com.uttkarsh.DataMapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> getAll(){
        return employeeRepository.findAll();
    }

    public EmployeeEntity findEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

}
