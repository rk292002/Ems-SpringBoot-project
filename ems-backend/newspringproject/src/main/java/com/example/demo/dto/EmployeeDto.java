package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class EmployeeDto {
private Long id;
private String firstname;
private String lastname;
private String email;
public EmployeeDto() {
	super();
}
public EmployeeDto(Long id, String firstname, String lastname, String email) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
}

public void setId(Long id) {
	this.id = id;
}
public Long getId() {
	return id;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getFirstname() {
	return firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
