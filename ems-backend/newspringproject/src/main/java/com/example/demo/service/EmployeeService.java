package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;

public interface EmployeeService {
EmployeeDto createEmployee(EmployeeDto employeeDto); //creating a method with return type employeedto;
 EmployeeDto getEmployeeById(Long employeeId);
 List<EmployeeDto>getAllEmployee();
}
