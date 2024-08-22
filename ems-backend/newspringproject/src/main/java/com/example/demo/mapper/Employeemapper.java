package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public class Employeemapper {
  public static EmployeeDto mapToEmployeeDto(Employee employee) {
	  return new EmployeeDto(
			  employee.getId(),
			  employee.getFirstname(),
			  employee.getLastname(),
			  employee.getEmail()
			  );
  }  ///mapping employee jpa entity to dto
  
  
  
  public static Employee mapToEmployee(EmployeeDto employeeDto) {
	  return new Employee(
			  employeeDto.getId(),
			  employeeDto.getFirstname(),
			  employeeDto.getLastname(),
			  employeeDto.getEmail()
			  );
  }  //mapping employeedto  to jpa entity 
  
}
