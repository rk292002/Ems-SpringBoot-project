package com.example.demo.entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @Entity
  @Table(name="employees")
  
  //we created a employee jpa entity
public class Employee {
	  @Id             //primarykey generation
	  @GeneratedValue(strategy= GenerationType.IDENTITY)  //automatically increment primarykey
  private Long id;
	  public Employee() {
			super();
		}
	public Employee(Long id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	  public long getId() {
			return id;
		}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	@Column(name="first_name")
  private String firstname;
	  @Column(name="last_name")
  private String lastname;
	  @Column(name="email_id",nullable=false,unique=true)
  private String email;
	
}
