package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.Employeemapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmailService;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;
 @Service    //why this used??  to create spring bean
 @AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{   //this implements employeeService class;
	 @Autowired
private EmployeeRepository employeeRepository;
	 @Autowired
	 private EmailService emailService;
	 
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=Employeemapper.mapToEmployee(employeeDto);
		Employee savedEmployee= employeeRepository.save(employee);
		String subject="Welcome to the website!";
		String body="Dear_"+employee.getFirstname()+", you have sucessfully registered";
		emailService.sendEmail(employee.getEmail(), subject, body);
		return Employeemapper.mapToEmployeeDto(savedEmployee);
	//return null;
	}
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}    
	
	@Override
public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee= employeeRepository.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with this id :" + employeeId));
		
	return Employeemapper.mapToEmployeeDto(employee);
}
	
	@Override
	public List<EmployeeDto> getAllEmployee(){
		List<Employee> employees= employeeRepository.findAll();	
		return employees.stream().map((employee) -> Employeemapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
				}
	
}
